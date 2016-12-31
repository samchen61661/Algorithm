/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        if (A == null) {
            return null;
        }
        int len = A.length;
        if (len == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        for (int i = 0; i <= len; i++) {
            TreeNode node = (i == len) ? new TreeNode(Integer.MAX_VALUE) : 
                    new TreeNode(A[i]);
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                node.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        
        return stack.pop().left;
    }
}
