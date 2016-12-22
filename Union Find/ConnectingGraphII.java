public class ConnectingGraph2 {
    private int[] father;
    private int[] count;
    public ConnectingGraph2(int n) {
        father = new int[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
            count[i] = 1;
        }
    }

    private int find (int a) {
        if (a == father[a]) {
            return a;
        } 
        father[a] = find(father[a]);
        return father[a];
    }

    public void connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count[rootB] += count[rootA]; 
        }
    }
        
    public int query(int a) {
        int root = find(a);
        return count[root];
    }
}
