/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        int max = 0;
        int min = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(root, 0));
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        map.put(0, list);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                Integer order = pair.order;
                
                if (node.left != null) {
                    queue.offer(new Pair(node.left, order - 1));
                    min = Math.min(min, order - 1);
                    
                    if (!map.containsKey(order - 1)) {
                        List<Integer> arrList = new ArrayList<>();
                        map.put(order - 1, arrList);
                    }
                    
                    map.get(order - 1).add(node.left.val);
                }
                
                if (node.right != null) {
                    queue.offer(new Pair(node.right, order + 1));
                    max = Math.max(max, order + 1);
                    
                    if (!map.containsKey(order + 1)) {
                        List<Integer> arrList = new ArrayList<>();
                        map.put(order + 1, arrList);
                    }
                    
                    map.get(order + 1).add(node.right.val);
                }
            }
        }
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}

class Pair {
    TreeNode node;
    Integer order;
    
    public Pair (TreeNode node, Integer order) {
        this.node = node;
        this.order = order;
    }
}
