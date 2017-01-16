/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p = dummyNode;
        ListNode q = dummyNode;
        
        while (true) {
            for (int i = 0; i < k; i++) {
                q = q.next;
                
                if (q == null) {
                    break;
                }
            }
            
            if (q == null) {
                break;
            }
            
            ListNode tmp = p.next;
            
            while (p.next != q) {
                ListNode nextNode = p.next;
                
                p.next = nextNode.next;
                nextNode.next = q.next;
                q.next = nextNode;
            }
            
            p = tmp;
            q = tmp;
        }
        
        return dummyNode.next;
    }
}
