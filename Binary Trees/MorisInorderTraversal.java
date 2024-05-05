/* https://www.naukri.com/code360/problems/inorder-traversal_3839605 */


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> inorder = new ArrayList<>();
        while(curr != null){
            if(curr.left == null) {
                inorder.add(curr.data);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }

            }
        }
        return inorder;
    }
}