public class Solution {
    /**
     * @param matrix an integer array of n * m matrix
     * @param k an integer
     * @return the maximum number
     */
    public int maxSlidingMatrix(int[][] matrix, int k) {
        if (matrix == null || k < 1) {
            return 0;
        }
        int row = matrix.length;
        if (row < k) {
            return 0;
        }
        int col = matrix[0].length;
        if (col < k) {
            return 0;
        }
        
        int[][] sum = new int[row + 1][col + 1];
        
        // Range sum
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = k; i <= row; i++) {
            for (int j = k; j <= col; j++) {
                max = Math.max(max, sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k]);
            }
        }
        
        return max;
    }
}
