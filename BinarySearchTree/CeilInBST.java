/* https://www.naukri.com/code360/problems/ceil-from-bst_920464 */

public class Solution {
    static int ceil;
    public  static int findCeil(TreeNode<Integer> node, int x) {
        ceil = Integer.MAX_VALUE;
        getCeil(node, x);
        if(ceil == Integer.MAX_VALUE) return -1;
        return ceil;
    }
    public static int getCeil(TreeNode<Integer> node, int x) {
        if(node == null) return ceil;
        if(node.data >= x && node.data < ceil) ceil = node.data;
        if(node.data >= x) return getCeil(node.left, x);
        getCeil(node.right, x);
        return ceil;
    }
}
