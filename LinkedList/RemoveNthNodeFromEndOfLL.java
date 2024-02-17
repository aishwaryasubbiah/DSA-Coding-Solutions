/* https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        for(int i=0; i<n; i++) {
            fast = fast.next;
        }
        if(fast == null) return head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}


/* Notes
Approach 1:
1. Find the length of the linked list
2. Loop from the start until the pointer reaches length - n
3. From this pointer, point to next->next.

Approach 2:
1. Move the fast pointer from start until n
2. Next move the slow pointer and fast pointer one step until the fast reaches null or fast->next is null.
3. Eventually, slow will be at the previous node to be deleted. 
4. Then connect, slow.next to next.next
5. Edge case - When n = length. So if fast is null, return slow.next
*/