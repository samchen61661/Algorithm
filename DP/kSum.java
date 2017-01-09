public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        if (A == null || k > A.length || target < 1) {
            return 0;
        }
        
        int len = A.length;
        int[][][] memo = new int[2][k + 1][target + 1];
        
        memo[0][0][0] = 1;
        
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m <= target; m++) {
                    memo[i % 2][j][m] = memo[(i - 1) % 2][j][m];
                    
                    if (m >= A[i - 1] && j > 0) {
                        memo[i % 2][j][m] += memo[(i - 1) % 2][j - 1][m - A[i - 1]];
                    }
                }
            }
        }
        
        return memo[len % 2][k][target];
    }
}
