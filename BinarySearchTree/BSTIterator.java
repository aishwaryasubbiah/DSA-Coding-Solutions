/* https://leetcode.com/problems/binary-search-tree-iterator/ */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root != null) {
          stack.push(root);
          root = root.left;
        }
    }
    
    public int next() {
        TreeNode currNext = stack.pop();
        if(currNext.right != null) { 
            TreeNode curr = currNext.right;
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }    
        return currNext.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
