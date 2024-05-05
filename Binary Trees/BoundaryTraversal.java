/* https://www.naukri.com/code360/problems/boundary-traversal-of-binary-tree_790725 */

import java.util.List;
import java.util.ArrayList;

public class Solution {
    static List<Integer> boundary = new ArrayList<Integer>();
    static List<Integer> rightboundary = new ArrayList<Integer>();
    public static List<Integer> traverseBoundary(TreeNode root){
        if(root == null) return boundary;
        boundary.add(root.data);
        if(root.left == null && root.right == null) return boundary;

        TreeNode leftNode = root.left;
        while(leftNode != null) {
            if(!boundary.contains(leftNode.data)) boundary.add(leftNode.data);
            if(leftNode.left == null) {
                leftNode = leftNode.right;
            } else { leftNode = leftNode.left; }
        }

        // Finding the child nodes
        findChildNodes(root);

        TreeNode rightNode = root.right;
        while(rightNode != null) {
            if(!boundary.contains(rightNode.data))
                rightboundary.add(rightNode.data);
            if(rightNode.right == null) {
                rightNode = rightNode.left;
            }  else {
                rightNode = rightNode.right;
            }  
        }
        int size =  rightboundary.size();
         for(int i=size-1; i>=0;i--) {
            boundary.add(rightboundary.get(i));
        }

       return boundary;
    }
    public static void findChildNodes(TreeNode childNode){
        // Finding the child nodes
        if(childNode == null) return;

        findChildNodes(childNode.left);
        if((childNode.left == null && childNode.right == null) && !boundary.contains(childNode.data)) boundary.add(childNode.data);
        findChildNodes(childNode.right); 
        
    }
}