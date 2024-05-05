/* https://www.naukri.com/code360/problems/preorder-traversal_3838888 */

public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	List<Integer> preorder = new ArrayList<>();
		TreeNode curr = root;

		while(curr != null){
			if(curr.left == null){
				preorder.add(curr.data);
                curr = curr.right;
			} else {
				TreeNode prev = curr.left;
				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if(prev.right == null){
					prev.right = curr;
					preorder.add(curr.data);
					curr = curr.left;
				} else {
					prev.right = null;
					curr = curr.right;
				}
			}
		}
		return preorder;
    }
}