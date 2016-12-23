/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return res;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for (UndirectedGraphNode node : nodes) {
            set.add(node.label);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                set.add(neighbor.label);
            }
        }
        
        UnionFind unionfind = new UnionFind(set);
        
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                unionfind.union(node.label, neighbor.label);
            }
        } 
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i : set) {
            // To determine whether the node is in the same set
            int root = unionfind.find(i);
            if (!map.containsKey(root)) {
                List<Integer> list = new ArrayList<>();
                map.put(root, list);
            }
            map.get(root).add(i);
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            res.add(list);
        }
        
        return res;
    }
}

class UnionFind {
    private HashMap<Integer, Integer> father;
    
    public UnionFind (HashSet<Integer> set) {
        father = new HashMap<>();
        for (Integer i : set) {
            father.put(i, i);
        }
    }
    
    // Iteration
    public int find (int label) {
        if (label == father.get(label)) {
            return label;
        }
        
        int fatherNode = father.get(label);
        while (fatherNode != father.get(fatherNode)) {
            fatherNode = father.get(fatherNode);
        }
        
        int root = fatherNode;
        fatherNode = label;
        
        while (fatherNode != father.get(fatherNode)) {
            father.put(fatherNode, root);
            fatherNode = father.get(fatherNode);
        }
        
        return root;
    }
    
    /*
    // Recursion
    public int find (int label) {
        if (label == father.get(label)) {
            return label;
        }
        father.put(label, find(father.get(label)));
        return father.get(label);
    }
    */
    
    public void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father.put(rootA, rootB);
        }
    }
} 