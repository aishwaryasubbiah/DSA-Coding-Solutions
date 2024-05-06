/* https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/ */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return constructBT(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderMap);
    }
    public TreeNode constructBT(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inorderMap.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;
        root.left = constructBT(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inorderMap);
        root.right =  constructBT(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inorderMap);
        return root;
    }
}