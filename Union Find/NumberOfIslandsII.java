/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<>();
        if (n < 1 || m < 1 || operators == null || operators.length == 0) {
            return res;
        }
        
        final int[] deltaX = {-1, 0, 1, 0};
        final int[] deltaY = {0, 1, 0, -1};
        
        UnionFind uf = new UnionFind(n * m);
        // It is not suitable to count the number of islands in the Union Find.
        int count = 0;
        boolean[][] isVisited = new boolean[n][m];
        
        for (Point operator : operators) {
            int x = operator.x;
            int y = operator.y;
            
            if (isVisited[x][y] != true) { 
                isVisited[x][y] = true;
                count++;
                
                for (int i = 0; i < 4; i++) {
                    int new_x = x + deltaX[i];
                    int new_y = y + deltaY[i];
                    
                    if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < m &&         isVisited[new_x][new_y]) {
                        int root = uf.find(x * m + y);
                        int new_root = uf.find(new_x * m + new_y);
                        
                        if (root != new_root) {
                            uf.union(x * m + y, new_x * m + new_y);
                            count--;
                        }
                    }
                }
            }
            
            res.add(count);
        }
        
        return res;
    }
}

class UnionFind {
    private int[] father;
    
    public UnionFind (int size) {
        father = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            father[i] = i;
        }
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
        } 
    }
}
