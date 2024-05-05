/* https://www.naukri.com/code360/problems/children-sum-property_8357239 */


// Approach 1 - Using stack

public class Solution {
    public static boolean isParentSum(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            if(currNode.left != null && currNode.right != null){
                if(currNode.left.data+currNode.right.data != currNode.data) return false;
                stack.push(currNode.left);
                stack.push(currNode.right);
            }
            else if(currNode.left != null) {
               if(currNode.left.data != currNode.data) return false;
               stack.push(currNode.left);
            } 
            else if(currNode.right != null) {
                if(currNode.right.data != currNode.data) return false;
                stack.push(currNode.right);
            }
        }
        return true;
    }
}


// Approach 2 - Using recursion

public class Solution {
    public static boolean isParentSum(Node root) {
        int ans = getChildSum(root);
        if(ans == root.data) return true;
        return false;
    }

    public static int getChildSum(Node root) {
        if(root == null) return 0;
        int left = getChildSum(root.left);
        int right = getChildSum(root.right);
      
       if((left == 0 && right == 0) || (left + right == root.data)) return root.data;
       return Integer.MAX_VALUE;
    }
}