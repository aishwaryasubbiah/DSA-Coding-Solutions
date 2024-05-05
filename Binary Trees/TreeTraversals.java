/* https://www.naukri.com/code360/problems/981269 */

public class Solution {
    static List<Integer> inorder = new ArrayList<>();
    static List<Integer> preorder = new ArrayList<>();
    static List<Integer> postorder = new ArrayList<>();
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> finaltraversals = new ArrayList<List<Integer>>();
        traversals(root);
        finaltraversals.add(inorder);
        finaltraversals.add(preorder);
        finaltraversals.add(postorder);
        return finaltraversals;
    }
    public static void traversals(TreeNode root){
        if(root == null) return;
        preorder.add(root.data);
        traversals(root.left);
        inorder.add(root.data);
        traversals(root.right);
        postorder.add(root.data);
    }
}