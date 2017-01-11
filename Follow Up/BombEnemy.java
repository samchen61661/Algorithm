public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Time complexity: O(mn)
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[] colCnt = new int[col];
        int rowCnt = 0;
        int max = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCnt = 0;
                
                    for (int k = j; k < col && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rowCnt++;
                        }
                    }
                }
                
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCnt[j] = 0;
                    
                    for (int k = i; k < row && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            colCnt[j]++;
                        }
                    }
                }
                
                if (grid[i][j] == '0' && (rowCnt + colCnt[j] > max)) {
                    max = rowCnt + colCnt[j];
                }
            }
        }
        
        return max;
    }
}
