/* https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1 */

class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> leftViewList = new ArrayList<>();
         if(root == null) return leftViewList;
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         
         while(!queue.isEmpty()){
             int size = queue.size();
             leftViewList.add(queue.peek().data);
             for(int i=0; i < size; i++)
             {
                 Node currNode = queue.remove();
                 if(currNode.left != null) queue.add(currNode.left);
                 if(currNode.right != null) queue.add(currNode.right);
             }
         }
    
        return leftViewList;
    }
}