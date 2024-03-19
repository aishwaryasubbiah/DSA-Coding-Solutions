/* https://www.interviewbit.com/problems/nearest-smaller-element/ */

public class Solution {
    public int[] prevSmaller(int[] A) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
       
        for(int i=0; i< A.length; i++) {
            if(stack.isEmpty()) {
                stack.push(A[i]);
                A[i] = -1;
            } else {
                int val = -1;
                while(!stack.isEmpty()) {
                    if(stack.peek() < A[i]) {
                        val = stack.peek();
                        break;
                    } else stack.pop();
                }
                stack.push(A[i]);
                A[i] = val;
            }
        }
        return A;
    }
}
