/* https://www.geeksforgeeks.org/problems/topological-sort/1 */

class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[V];
        int[] topoSort = new int[V];
        Set<Integer> vis = new HashSet<Integer>();
        int k=0;
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(indegree, 0);
        for(int i=0; i < V; i++) {
            for(int j=0; j< adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)] += 1; 
            }
        }
        
        for(int i=0; i < V; i++) {
           if(indegree[i] == 0) queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            int currNode = queue.remove();
            vis.add(currNode);
            topoSort[k++] =currNode;
            for(int i=0; i < adj.get(currNode).size(); i++) {
               indegree[adj.get(currNode).get(i)] -= 1;
               if(indegree[adj.get(currNode).get(i)] == 0 && !vis.contains(adj.get(currNode).get(i))) queue.add(adj.get(currNode).get(i));
            }
        }
        return topoSort;
        
    }
}