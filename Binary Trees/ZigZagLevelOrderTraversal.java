/* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/ */

/* Soution 1 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> zigzagtraversal = new ArrayList<List<Integer>>();
        if(root == null) return zigzagtraversal;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        int order = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty())
        {
            List<Integer> currList = new ArrayList<>();
            if(order % 2 != 0) {
                int size = stack1.size();
                for(int i=0; i < size; i++) {
                    TreeNode currNode = stack1.pop();
                    currList.add(currNode.val);
                    if(currNode.left != null) stack2.push(currNode.left);
                    if(currNode.right != null) stack2.push(currNode.right);
                }
            } else {
                int size = stack2.size();
                for(int i=0; i < size; i++) {
                    TreeNode currNode = stack2.pop();
                    currList.add(currNode.val);
                    if(currNode.right != null) stack1.push(currNode.right);
                    if(currNode.left != null) stack1.push(currNode.left);
                }
            }
            order++;
            zigzagtraversal.add(currList);
        }
        return zigzagtraversal;
    }
}

/* Notes 
1. Using 2 stacks
2. First level on 1 stack
2. Next level on another stack
*/ 

/* Solution 2 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) 
            return result;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int count = 1;
        Stack<TreeNode> dummyst = new Stack<>();
        while(!st.isEmpty())
        {
            int size = st.size();
            dummyst.clear();
            List<Integer> eachlevel = new ArrayList<>();
            for(int i = 0;i < size; i++){
                TreeNode current =  st.pop();
                if(count % 2 == 0){
                   if(current.right != null){
                     dummyst.push(current.right);
                   }
                   if(current.left != null) {
                      dummyst.push(current.left);
                   }                   
                }
                else {
                    if(current.left != null) {
                       dummyst.push(current.left);
                   }        
                   if(current.right != null){
                     dummyst.push(current.right);
                   }    
                }
                eachlevel.add(current.val);
            }
            st = (Stack<TreeNode>)dummyst.clone();
            result.add(eachlevel);
            count++;
        }
        return result;
    }
}

/* Notes 
1. Using 2 stacks
2. First level on 1 stack
3. Storing the subsequent levels on dummy stack
4. After the stack 1 looping is completed, clone the dummy stack data to original stack
*/ 