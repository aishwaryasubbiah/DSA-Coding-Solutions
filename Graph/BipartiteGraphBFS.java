/* https://leetcode.com/problems/is-graph-bipartite/ */

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        Set<Integer> vis = new HashSet<>();
        
        for(int i=0; i< graph.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = i;
            if(!vis.contains(i)) {
                while(!queue.isEmpty()) {
                    int currNode = queue.remove();
                    int currColor = color[currNode];

                    for(int j=0; j<graph[currNode].length; j++) {
                        int adjNode = graph[currNode][j];
                        if(color[adjNode] == -1) { 
                            color[adjNode] = currColor == 0 ? 1 : 0;
                            queue.add(adjNode);
                            vis.add(adjNode);
                        }
                        else if(color[adjNode] == currColor) return false;
                    }
                }
            }
        }
       
        return true;
    }
}