public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // It is better to use BFS.
        // Time complexity: O(N)    Space complexity: O(N)
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        Queue<Node> queue = new LinkedList<>();
        final int[] deltaX = {-1, 0, 1, 0};
        final int[] deltaY = {0, 1, 0, -1};
        
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
