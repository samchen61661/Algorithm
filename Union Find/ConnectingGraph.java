public class ConnectingGraph { 
    private int[] father;
    public ConnectingGraph(int n) {
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
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
        }
    }
        
    public boolean  query(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }
}
