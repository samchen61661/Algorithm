/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    // hash
    // time complexity: O(n) space complexity: O(n)
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        return traverse_tree_with_set(root, set, k);
    }
    
    private boolean traverse_tree_with_set(TreeNode root, HashSet<Integer> set, int target) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return traverse_tree_with_set(root.left, set, target) || traverse_tree_with_set(root.right, set, target);
    } 
    */
    
    /*
    // sort
    // time complexity: O(n) space complexity: O(n)
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inorder_traversal(root, list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    
    private void inorder_traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder_traversal(root.left, list);
        list.add(root.val);
        inorder_traversal(root.right, list);
    }
    */
    
    // binary search
    // time complexity: O(n * depth) space complexity: O(depth) 
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return inorder_traversal(root, k, root);
    }
    
    private boolean inorder_traversal(TreeNode cur_node, int k, TreeNode root) {
        if (cur_node == null) {
            return false;
        }
        return inorder_traversal(cur_node.left, k, root) || binary_search_node(cur_node, root, k - cur_node.val) || inorder_traversal(cur_node.right, k, root);
    }
    
    private boolean binary_search_node(TreeNode cur_node, TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        // Depends on how BST handles duplicates 
        if (root.val == val && cur_node != root) {
            return true;
        } else if (root.val <= val) {
            return binary_search_node(cur_node, root.right, val);
        } else {
            return binary_search_node(cur_node, root.left, val);
        }
    }
}
