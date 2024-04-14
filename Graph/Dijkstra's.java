/* https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1 */

class pqData {
    int dist, node;
    pqData(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<pqData> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        distance[S] = 0;
        pq.add(new pqData(0, S));
        
        while(!pq.isEmpty()) {
            int currNode = pq.peek().node;
            int currdist = pq.peek().dist;
            pq.remove();
            
            for(int j=0; j< adj.get(currNode).size(); j++){
                int adjnode = adj.get(currNode).get(j).get(0);
                int adjdist = adj.get(currNode).get(j).get(1);
                
                if(currdist+adjdist < distance[adjnode]) {
                    distance[adjnode] = currdist + adjdist;
                    pq.add(new pqData(currdist+adjdist, adjnode));
                }
            }
        }
        return distance;
    }
}
