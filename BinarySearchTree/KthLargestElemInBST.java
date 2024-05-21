/* https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1 */

class Solution
{
    int count = 0, kthLargestElem = 0;
    public int kthLargest(Node root,int K)
    {

       if(root == null) return 0;
       kthLargest(root.right, K);
       count += 1;
       if(count == K) kthLargestElem = root.data;
       kthLargest(root.left, K);
       return kthLargestElem;
    }
}