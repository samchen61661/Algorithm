public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        final int[] deltaX = {-1, 0, 1, 0};
        final int[] deltaY = {0, 1, 0, -1};
        
        /*
        // BFS.
        // Time complexity: O(N)    Space complexity: O(N)
        Queue<Node> queue = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Node(i, 0));
                board[i][0] = 'W';
            }
            if (board[i][col - 1] == 'O') {
                queue.offer(new Node(i, col - 1));
                board[i][col - 1] = 'W';
            }
        }
        
        for (int i = 1; i < col - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new Node(0, i));
                board[0][i] = 'W';
            }
            if (board[row - 1][i] == 'O') {
                queue.offer(new Node(row - 1, i));
                board[row - 1][i] = 'W';
            }
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int new_x = node.x + deltaX[i];
                int new_y = node.y + deltaY[i];
                if (new_x >= 0 && new_y >= 0 && new_x < row && new_y < col &&         board[new_x][new_y] == 'O') {
                    board[new_x][new_y] = 'W';
                    queue.offer(new Node(new_x, new_y));
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                }
            }
        }
        */
        
        // Union Find
        UnionFind uf = new UnionFind(row * col);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    int new_x = i + deltaX[k];
                    int new_y = j + deltaY[k];
                    if (new_x >= 0 && new_y >= 0 && new_x < row && new_y < col) {
                        if (board[i][j] == board[new_x][new_y]) {
                            uf.union(i * col + j, new_x * col + new_y);
                        }
                    }
                }
            }
        }
        
        HashSet<Integer> rootSet = new HashSet<>();
        
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                rootSet.add(uf.find(i * col));
            }
            if (board[i][col - 1] == 'O') {
                rootSet.add(uf.find(i * col + col - 1));
            }
        }
        
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                rootSet.add(uf.find(i));
            }
            if (board[row - 1][i] == 'O') {
                rootSet.add(uf.find((row - 1) * col + i));
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !rootSet.contains(uf.find(i * col + j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class UnionFind {
    private int[] father;
    
    public UnionFind (int n) {
        father = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
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

class Node {
    public int x;
    public int y;
    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
