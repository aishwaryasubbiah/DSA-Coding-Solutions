/* https://leetcode.com/problems/kth-largest-element-in-an-array/description/ */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++) pq.add(nums[i]);
        int count =0;
        while(!pq.isEmpty()) {
            count++;
            if(count == k) break;
            pq.remove();
        }
        return pq.remove();
    }
}