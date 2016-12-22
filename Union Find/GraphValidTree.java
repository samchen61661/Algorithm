public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n < 1 || edges == null) {
            return false;
        }
        
        // We have to accept empty edge, so we don't check "edges" array.
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            int root0 = uf.find(edge[0]);
            int root1 = uf.find(edge[1]);
            if (root0 == root1) {
                return false;
            }
            uf.union(root0, root1);
        }
        
        return uf.getCount() == 1;
    }
}

class UnionFind {
    private int[] father;
    private int count;
    public UnionFind (int size) {
        father = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            father[i] = i;
        }
        count = size;
    }
    
    public int find (int a) {
        if (a == father[a]) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
    
    public void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count--;
        }
    }
    
    public int getCount() {
        return count;
    }
}
