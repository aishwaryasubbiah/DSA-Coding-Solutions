/* https://leetcode.com/problems/balanced-binary-tree/description/ */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        int ans = heightOfTree(root);
        return ans != Integer.MAX_VALUE;
    }
    public int heightOfTree(TreeNode root) {
        if(root == null) return 0;
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        int height;
        if(left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) height = Integer.MAX_VALUE;
        else height = (Math.max(left, right) + 1);
        if(Math.abs(left-right) > 1) return Integer.MAX_VALUE;
        return height;
    }
} 