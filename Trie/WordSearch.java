public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
     
    private final int[] deltaX = {-1, 0, 1, 0};
    private final int[] deltaY = {0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        if (board == null) {
            return false;
        }
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;
        if (col == 0) {
            return false;
        }
        
        
        // DFS
        boolean[][] isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, i, j, new StringBuilder(), isVisited)) {
                    return true;
                }
            }
        }
        
        return false;
      
    }
    
    private boolean dfs (char[][] board, String word, int i, int j, StringBuilder builder, boolean[][] isVisited) {
        if (word.length() == builder.length()) {
            return true;
        }
        
        int row = board.length;
        int col = board[0].length;
        if (i >= 0 && j >= 0 && i < row && j < col && !isVisited[i][j]) {
            if (word.charAt(builder.length()) == board[i][j]) {
                builder.append(board[i][j]);
                isVisited[i][j] = true;
                
                for (int k = 0; k < 4; k++) {
                    int new_x = i + deltaX[k];
                    int new_y = j + deltaY[k];
                    if (dfs(board, word, new_x, new_y, builder, isVisited)) {
                    return true;
                }
                }
                
                isVisited[i][j] = false;
                builder.setLength(builder.length() - 1);
            }
            
        }
        
        return false;
    }
}
