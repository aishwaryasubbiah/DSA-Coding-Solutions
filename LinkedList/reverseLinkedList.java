/* https://leetcode.com/problems/reverse-linked-list/description/ */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        ListNode l = head;
        if(head == null || head.next == null) return head;
        while(head.next != null){
           l = l.next;
           head.next = reverse;
           reverse = head;
           head = l;
        }
        head.next = reverse;
        return head;
    }
}