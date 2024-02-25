/* https://leetcode.com/problems/rotate-list/description/ */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        ListNode temp = head; 
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        if(length == k) return head;
        temp = head;
        ListNode start = null;
        int n = length - k, count = 0;
        if(k >= length) {
            k = k % length;
            n = Math.abs(length - k);
        }
        if(n == length) return head;
        while(temp != null) {
            count++;
            if(count < n) {
                temp = temp.next;
            } else {
                start = temp.next;
                temp.next = null;
                break;
            }
        }

        ListNode end = start;
        while(end != null && end.next != null) {
            end = end.next;
        }
        end.next = head;
        return start;
    }
}