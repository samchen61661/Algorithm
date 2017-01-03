/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        
        ListNode i = dummyNode;
        ListNode j = dummyNode;
        
        for (int k = 0; k < n; k++) {
            j = j.next;
        }
        
        while (j.next != null) {
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;
        
        return dummyNode.next;
    }
}
