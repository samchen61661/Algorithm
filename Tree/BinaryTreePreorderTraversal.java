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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        /*
        // Iterative
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            res.add(node.val);
            
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return res;
        */
        
        /*
        // Divide & Conquer
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        
        return res;
        */
        
        // traverse
        helper(res, root);
        
        return res;
    }
    
    private void helper (ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
}
