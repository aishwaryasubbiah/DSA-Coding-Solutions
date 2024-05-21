/* https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/ */
class Solution {
    int count = 0, kthSmallElem;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        kthSmallest(root.left, k);
        count += 1;
        if(count == k) kthSmallElem = root.val;
        kthSmallest(root.right, k);
        return kthSmallElem;
    }
}