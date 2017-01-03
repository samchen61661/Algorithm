public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] memo = new int[2][col + 1];
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    memo[i % 2][j] = Math.min(memo[(i - 1) % 2][j - 1], 
                            Math.min(memo[(i - 1) % 2][j], memo[i % 2][j - 1])) 
                            + 1;
                    max = Math.max(max, memo[i % 2][j]);
                } else {
                    memo[i % 2][j] = 0;
                }    
            }
        }
        
        return max * max;
    }
}
