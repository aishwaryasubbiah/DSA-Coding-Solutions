/* https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1 */

class pqData {
    int weight, node, parent;
    pqData(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
          
        int minDist = 0;
        PriorityQueue<pqData> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new pqData(0, 0, -1));
        Set<Integer> vis = new HashSet<>();
        
        while(!pq.isEmpty()) {
            int currwt = pq.peek().weight;
            int currNode = pq.peek().node;
            int currParent = pq.peek().parent;
            pq.remove();

            if(vis.contains(currNode)) {
                continue;
            }
            vis.add(currNode);
            minDist += currwt;

            for(int i=0; i<edges.length; i++) {
                if(edges[i][0] == currNode && !vis.contains(edges[i][1]) && edges[i][0] != currParent) {
                    pq.add(new pqData(edges[i][2], edges[i][1], currNode));
                } else if(edges[i][1] == currNode && !vis.contains(edges[i][0]) && edges[i][1] != currParent) {
                    pq.add(new pqData(edges[i][2], edges[i][0], currNode));
                }
            }
        }
        return minDist;
	}
}