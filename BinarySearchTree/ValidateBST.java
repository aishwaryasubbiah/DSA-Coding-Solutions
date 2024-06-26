/* https://leetcode.com/problems/validate-binary-search-tree/ */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);  
    }
    public boolean checkBST(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}
