/* https://leetcode.com/problems/copy-list-with-random-pointer/description/ */

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        while(temp != null) {
           Node newNode = new Node(temp.val);
           newNode.next = temp.next;
           temp.next = newNode;
           temp = temp.next.next;
        }
        temp = head;
        while(temp!= null && temp.next != null) {
            if(temp.random != null) temp.next.random = temp.random.next;
            else temp.next.random = temp.random;
            temp = temp.next.next;
        }
        temp = head;
        Node finalist = head.next;
        while(temp != null) {
            Node temp2 = temp.next;
            temp.next = temp.next.next;
            if(temp2.next != null) temp2.next = temp2.next.next;
            temp = temp.next;
            temp2 = temp2.next;            
        }
        return finalist;
    }
}