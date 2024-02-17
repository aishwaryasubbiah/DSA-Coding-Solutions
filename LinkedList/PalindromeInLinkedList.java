/* https://leetcode.com/problems/palindrome-linked-list/description/ */

class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head, fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode rev = null;
        ListNode temp = slow, l1 = head;
        while(slow != null) {
            slow = slow.next;
            temp.next = rev;
            rev = temp;
            temp = slow;
        }

        while(l1 != null && rev != null) {
            if(l1.val != rev.val) return false;
            l1 = l1.next; 
            rev = rev.next;
        }
        return true;
    }
}


/* Notes
1. Find the middle of the linked list using Floyd's algorithm(Tortoise and Hare algorithm)
2. Reverse the second half of the linked list
3. Check the two linked list for the same values
*/