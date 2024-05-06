/* https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/ */

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return constructBT(inorder, 0, inorder.length-1, postorder, postorder.length-1, 0, inorderMap);
    }
    public TreeNode constructBT(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inorderMap) {
         if(postEnd > postStart || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int inRoot = inorderMap.get(postorder[postStart]);
        int numsleft = inRoot - inStart;
        root.left = constructBT(inorder, inStart, inRoot-1, postorder, (postEnd + numsleft)-1, postEnd,inorderMap);
        root.right = constructBT(inorder, inRoot+1, inEnd, postorder, postStart -1, postEnd+numsleft, inorderMap);
        return root;
    }
}