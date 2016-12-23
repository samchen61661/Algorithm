public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
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
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, i, j, new StringBuilder())) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs (char[][] board, String word, int i, int j, StringBuilder builder) {
        if (word.length() == builder.length()) {
            return true;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        if (i >= 0 && j >= 0 && i < row && j < col && board[i][j] != '0') {
            if (word.charAt(builder.length()) == board[i][j]) {
                builder.append(board[i][j]);
                char c = board[i][j];
                board[i][j] = '0';
                
                if (dfs(board, word, i + 1, j, builder)) {
                    return true;
                }
                if (dfs(board, word, i - 1, j, builder)) {
                    return true;
                }
                if (dfs(board, word, i, j - 1, builder)) {
                    return true;
                }
                if (dfs(board, word, i, j + 1, builder)) {
                    return true;
                }  
                
                board[i][j] = c;
                builder.setLength(builder.length() - 1);
            }
        }
        
        return false;
    }
}

