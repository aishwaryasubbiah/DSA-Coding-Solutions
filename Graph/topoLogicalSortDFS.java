/* https://www.geeksforgeeks.org/problems/topological-sort/1 */

class Solution
{
    static Stack<Integer> stack;
    static Set<Integer> vis;
    static void dfs(ArrayList<ArrayList<Integer>> adj, int currNode){
        vis.add(currNode);
        
        for(int j=0; j< adj.get(currNode).size(); j++) {
            if(!vis.contains(adj.get(currNode).get(j))) {
                dfs(adj, adj.get(currNode).get(j));
            }
        } 
        stack.push(currNode);
    }
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        stack = new Stack<>();
        vis = new HashSet<>();
        int[] topoSort = new int[V];
        int k=0;
        for(int i=0; i< V; i++){
           if(!vis.contains(i)) dfs(adj, i);
        }
       
        while(!stack.isEmpty()) {
           topoSort[k++] = stack.pop();
        }
        return topoSort;
    }
}
