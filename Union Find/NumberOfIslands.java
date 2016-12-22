public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        /*
        // Union Find
        // Time complexity: O(m * n) Space Complexity: O(m * n)
        int count = 0;
        for (boolean[] cells : grid) {
            for (boolean cell : cells) {
                if (cell) {
                    count++;
                }
            }
        }
        
        UnionFind uf = new UnionFind(row * col, count);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]) {
                    int index = i * col + j;
                
                    if (i - 1 >= 0 && grid[i - 1][j]) {
                        uf.union(index, (i - 1) * col + j);
                    }
                    if (i + 1 < row && grid[i + 1][j]) {
                        uf.union(index, (i + 1) * col + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1]) {
                        uf.union(index, i * col + j - 1);
                    }
                    if (j + 1 < col && grid[i][j + 1]) {
                        uf.union(index, i * col + j + 1);
                    }
                }
            }
        }
        
        return uf.getCount();
        */
        
        /*
        // DFS 
        // Time complexity: O(m * n) Space Complexity: O(m * n)
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
        */
        
        // BFS
        // Time complexity: O(m * n) Space Complexity: O(m * n)
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfs (boolean[][] grid, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        
        queue.add(i * col + j);
        grid[i][j] = false;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / col;
            int y = index % col;
            
            if (x - 1 >= 0 && grid[x - 1][y]) {
                queue.add((x - 1) * col + y);
                grid[x - 1][y] = false;
            }
            if (x + 1 < row && grid[x + 1][y]) {
                queue.add((x + 1) * col + y);
                grid[x + 1][y] = false;
            }
            if (y - 1 >= 0 && grid[x][y - 1]) {
                queue.add(x * col + y - 1);
                grid[x][y - 1] = false;
            }
            if (y + 1 < col && grid[x][y + 1]) {
                queue.add(x * col + y + 1);
                grid[x][y + 1] = false;
            }
        }
    }
    
    private void dfs (boolean[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        
        if (i >= 0 &&  i < row && j >= 0 && j < col && grid[i][j]) {
            grid[i][j] = false;
        
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}


// Union Find
class UnionFind {
    private int[] father;
    private int count;
    
    public UnionFind (int size, int count) {
        father = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            father[i] = i;
        }
        this.count = count;
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
