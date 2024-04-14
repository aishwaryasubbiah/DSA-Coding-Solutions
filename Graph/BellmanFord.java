/* https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/0?fbclid=IwAR2_lL0T84DnciLyzMTQuVTMBOi82nTWNLuXjUgahnrtBgkphKiYk6xcyJU */

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, 100000000);
        
        distance[S] = 0;
        for(int i=0; i<V; i++) {
            for(int j=0; j< edges.size(); j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                if(distance[u] != 100000000 && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        } 
         for(int j=0; j< edges.size(); j++) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int wt = edges.get(j).get(2);
            if(distance[v] != 100000000 && distance[u] + wt < distance[v]) {
               int[] temp = new int[1];
               temp[0] = -1;
               return temp;
            }
        }
        return distance;
    }
}