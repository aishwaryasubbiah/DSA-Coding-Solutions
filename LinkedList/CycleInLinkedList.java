/* https://leetcode.com/problems/linked-list-cycle/description/ */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

/* Notes
Floyd's Algorithm - Also known as Hare and Tortoise Algorithm
Uses slow and fast pointer to detect the cycle.
Slow and fast pointer starts at the same point but slow moves 1 step whereas fast moves 2 steps.
If slow and fast meets then there is a cycle
else no cycle
*/