/* https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1 */

class Solution
{   
    Stack<Integer> stack;
    ArrayList<ArrayList<Integer>> reversedGraph;
    Set<Integer> vis;
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean isSortEdge) {
        vis.add(node);
        for(int j=0; j< adj.get(node).size(); j++){
            if(!vis.contains(adj.get(node).get(j))) dfs(adj, adj.get(node).get(j), isSortEdge);
        }
        if(isSortEdge) stack.push(node);
    }

    public void SortNodesByFinishingTime(ArrayList<ArrayList<Integer>> adj, int V) {
        for(int i=0; i<V; i++) {
            if(!vis.contains(i)) dfs(adj, i, true);
        }
    }
    
    public void reverseGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        reversedGraph = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i < adj.size(); i++){
            ArrayList<Integer> adjList = new ArrayList<>();
            reversedGraph.add(adjList);
        }
        for(int i=0; i < adj.size(); i++){
            for(int j=0; j < adj.get(i).size(); j++){
                int adjNode = adj.get(i).get(j);
                reversedGraph.get(adjNode).add(i);
            }
        }
    }
    
    public int findStronglyConnected(ArrayList<ArrayList<Integer>> adj, int V) {
        int count = 0;
        while(!stack.isEmpty()) {
            int currNode = stack.pop();
            if(!vis.contains(currNode)) { 
                count+=1;
                dfs(adj, currNode, false);
            }
        }
        return count;
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        stack = new Stack<>();
        vis = new HashSet<>();
        SortNodesByFinishingTime(adj, V);
        reverseGraph(adj, V);
        vis = new HashSet<>();
        return findStronglyConnected(reversedGraph, V);
        
    }
}


/* Notes 
Kosaraju's Algorithm
1. Sort the nodes based on finishing time - Put in the stack which node gets completed first
2. Reverse the graph
3. Do dfs on popping the stack - After every dfs count it. That will be the strongly connected components.
*/