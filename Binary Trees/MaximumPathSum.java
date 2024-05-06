/* https://leetcode.com/problems/binary-tree-maximum-path-sum/description/ */

class Solution {
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxi;
    }
    public int findMaxPath(TreeNode node){
        if(node == null) return 0;
        int leftSum = Math.max(0,findMaxPath(node.left));
        int rightSum = Math.max(0, findMaxPath(node.right));
        maxi = Math.max(maxi, leftSum+rightSum+node.val);
        return (node.val + Math.max(leftSum, rightSum));
    }
}