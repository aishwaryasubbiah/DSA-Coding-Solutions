/* https://leetcode.com/problems/is-graph-bipartite/ */

class Solution {
    int[] color;
    Set<Integer> vis = new HashSet<>();
    public boolean checkBipartite(int[][] graph, int node, int fillcolor) {
        vis.add(node);
        if(color[node] == -1) color[node] = fillcolor;
        for(int j=0; j<graph[node].length; j++) {
            if(!vis.contains(graph[node][j])) {
               if(checkBipartite(graph, graph[node][j], (fillcolor == 0 ? 1 : 0)) == false) return false;
            }
            else if(color[graph[node][j]] == fillcolor) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        color  = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i< graph.length; i++) {
            if(!vis.contains(i)) {
                if(checkBipartite(graph, i, 0) == false) return false;
            }
        }
       
        return true;
    }
}