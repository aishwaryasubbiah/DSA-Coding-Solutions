/* https://leetcode.com/problems/merge-two-sorted-lists/submissions/ */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0);
        ListNode traverse = mergedList;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val)
            {
               traverse.next = list1;
               list1 = list1.next;
            }
            else {
                traverse.next = list2;
                list2 = list2.next;
            }
            traverse = traverse.next;
        }
        if(list1!= null) traverse.next = list1;
        else if(list2 != null) traverse.next = list2;
        return mergedList.next;
    }
}