/* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/ */

// Approach 1 - Using stack

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);  
        while(!stack.isEmpty()){
           TreeNode currNode = stack.pop();
           if(currNode.right != null) stack.push(currNode.right);
           if(currNode.left != null) stack.push(currNode.left);

           if(currNode.left != null) {
              currNode.right = currNode.left;
           } 
           if(currNode.left == null && currNode.right == null) {
              if(!stack.isEmpty()) {
                currNode.right = stack.peek();
              } else currNode.right = null;    
           } 
           currNode.left = null;  
        }
       
    }
}

// Approach 2 - Using Recursion

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
