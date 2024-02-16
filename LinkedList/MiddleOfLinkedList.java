/* https://leetcode.com/problems/middle-of-the-linked-list/description/ */

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

/* Notes 
Floyd's algorithm - slow and fast pointers
When fast ends, return the slow pointer - Slow will be at the middle of the linked list
*/