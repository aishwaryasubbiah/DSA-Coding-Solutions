/* https://leetcode.com/problems/diameter-of-binary-tree/ */

class Solution {
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    public int height(TreeNode root) {
        if(root == null) return 0;
        int x = height(root.left);
        int y = height(root.right);
        diameter = Math.max(diameter, x+y);
        return Math.max(x, y) +1;
    }
}