/* https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1 */

class Disjoint{
    int size[], parent[];
    
    Disjoint(int V){
        size = new int[V];
        parent = new int[V];
        Arrays.fill(size, 1);
        for(int i=0; i<V; i++){
            parent[i] = i;
        }
    }
    
    public int findUltimateParent(int u) {
        if(u == parent[u]) return u;
        return parent[u] = findUltimateParent(parent[u]);
    }
    
    public void Union(int u, int v){
        int ultu = findUltimateParent(u);
        int ultv = findUltimateParent(v);
        if(ultu == ultv) return;
        if(size[ultu] < size[ultv]) {
            size[ultv] += size[ultu];
            parent[ultu] = parent[ultv];
        } else {
            size[ultu] += size[ultv];
            parent[ultv] = parent[ultu];
        }
    }
}

class pqData {
    int weight, u, v;
    pqData(int weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    PriorityQueue<pqData> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
	    int mindist = 0;
	    Disjoint ds = new Disjoint(V);

	     for(int i=0; i< edges.length; i++) {
	         pq.add(new pqData(edges[i][2], edges[i][0], edges[i][1]));
	    }
	   
	    while(!pq.isEmpty()) {
	        int ultpu = ds.findUltimateParent(pq.peek().u);
	        int ultpv = ds.findUltimateParent(pq.peek().v);
	        if(ultpu != ultpv){
	            ds.Union(pq.peek().u, pq.peek().v);
	            mindist += pq.peek().weight;
	        }
	        pq.remove();
	    }
	    return mindist;
	}
}

/* Notes
1. Sort the edges
2. Use disjoint set. If the pair is already present then dont add in the mst.
*/