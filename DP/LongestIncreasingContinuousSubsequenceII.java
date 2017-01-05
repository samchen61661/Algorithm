public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    private final int[] deltaX = {-1, 0, 1, 0};
    private final int[] deltaY = {0, 1, 0, -1};
    
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int row = A.length;
        int col = A[0].length;
        
        int[][] memo = new int[row][col];
        boolean[][] isVisited = new boolean[row][col];
        int max = 1;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, search(A, memo, isVisited, i, j));
            }
        }
        
        return max;
    }
    
    private int search(int[][] A, int[][] memo, boolean[][] isVisited, int i, 
            int j) {
        int row = A.length;
        int col = A[0].length;

        if (isVisited[i][j]) {
            return memo[i][j];
        }
        
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int new_x = i + deltaX[k];
            int new_y = j + deltaY[k];
            
            if (new_x >= 0 && new_y >= 0 && new_x < row && new_y < col 
                    && A[i][j] < A[new_x][new_y]) {
                max = Math.max(max, search(A, memo, isVisited, new_x, new_y) + 1);
            }
        }
        
        isVisited[i][j] = true;
        memo[i][j] = max;
        return memo[i][j];
    }
}
