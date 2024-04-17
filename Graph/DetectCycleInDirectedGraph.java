/* https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1 */

// BFS - Using Topological Sort

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(indegree, 0);

        for(int i=0; i<adj.size(); i++){
            for(int j=0; j<adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)] += 1;
            }
        } 

        for(int i=0; i<V; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        for(int i=0; i<V; i++) {
            if(!vis.contains(i)) {
                while(!queue.isEmpty()) {
                    int currNode = queue.remove();
                    vis.add(currNode);
                    for(int j=0; j<adj.get(currNode).size(); j++){
                        indegree[adj.get(currNode).get(j)] -= 1;
                        if(indegree[adj.get(currNode).get(j)] == 0) queue.add(adj.get(currNode).get(j));
                    }
                }
            }
        }

        for(int i=0; i<V; i++){
            if(indegree[i] != 0) return true;
        }
        return false;
    }
}

/* DFS - Using vis and pathvisited array */ 

class Solution {
    int[] vis;
    int[] pathvis;
    public boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int node) {
        vis[node] = 1;
        pathvis[node] = 1;
        for(int i=0; i< adj.get(node).size(); i++) {
            if(vis[adj.get(node).get(i)] != 1) { 
                if(checkCycle(adj, adj.get(node).get(i)) == true) return true;
            } 
            else if(vis[adj.get(node).get(i)] == 1 && pathvis[adj.get(node).get(i)] == 1) return true;
        }
        pathvis[node] = 0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new int[V];
        pathvis = new int[V];
        Arrays.fill(vis, 0);
        Arrays.fill(pathvis, 0);
        for(int i=0; i<V; i++) {
            if(vis[i] != 1) {
                if(checkCycle(adj, i) == true) return true;
            }
        }
        return false;
    }
}