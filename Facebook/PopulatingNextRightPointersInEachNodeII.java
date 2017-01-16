/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyNode = new TreeLinkNode(-1);
        TreeLinkNode p = root;
        TreeLinkNode q = dummyNode;
        
        while (p != null) {
            while (p != null) {
                if (p.left != null) {
                    q.next = p.left;
                    q = q.next;
                }
                
                if (p.right != null) {
                    q.next = p.right;
                    q = q.next;
                }
                
                p = p.next;
            }
            
            p = dummyNode.next;
            dummyNode.next = null;
            q = dummyNode;
        }
    }
}
