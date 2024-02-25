/* https://leetcode.com/problems/sort-colors/description/ */

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1, temp;
        while(mid <= high) {
            if(nums[mid] == 0) {
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1) mid++;
            else if(nums[mid] == 2) {
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}

/* Notes 
Dutch National flag algorithm
Using low, mid and high - 3 pointers. 
*/
