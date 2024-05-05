/* https://www.naukri.com/code360/problems/all-root-to-leaf-paths-in-binary-tree._983599 */

public class Solution {
    static List<String> finaloutput = new ArrayList<>();
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        if(root.left == null && root.right == null) {
            String str = root.data+"";
            finaloutput.add(str);
            return finaloutput;
        }
        traverse(root, "");
        return finaloutput;
    }

    public static void traverse(BinaryTreeNode root, String currString){
        if(root == null) return;
    
        currString = currString + (root.data) + " ";
        if(root.left == null && root.right == null) {
            if(!finaloutput.contains(currString)) finaloutput.add(currString);
        }
        traverse(root.left, currString);
        traverse(root.right, currString);
    }
}