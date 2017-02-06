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
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        /*
        helper(res, root);
        */
        
        
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;    
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;        
                }
            }
        }

        return res;
    }
    
    private void helper (ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}
