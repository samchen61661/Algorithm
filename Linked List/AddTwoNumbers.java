/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null? l2 : l1;
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode pointer = dummyNode;
        int c = 0;
        
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + c;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            c = sum / 10;
        }
        if (c != 0) {
            pointer.next = new ListNode(c);
        }
        
        return dummyNode.next;
    }
}
