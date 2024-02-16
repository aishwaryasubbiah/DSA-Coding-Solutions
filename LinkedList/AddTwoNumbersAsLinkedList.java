/* https://leetcode.com/problems/add-two-numbers/description/ */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int balance = 0;
        ListNode t1 = l1, t2 = l2;
        ListNode finallist = new ListNode(0);
        ListNode loop = finallist;
        while(l1 != null || l2 != null) {
            int add = 0;
            if(l1 != null) {
               add += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
               add += l2.val;
               l2 = l2.next;
            }
            ListNode newNode = new ListNode((add + balance) % 10);
            balance = (add + balance) / 10;
            loop.next = newNode;
            loop = loop.next;
        }
        if(balance != 0) {
            ListNode newNode = new ListNode(balance);
            loop.next = newNode;
            loop = loop.next;
        }
        return finallist.next;
        
    }
}