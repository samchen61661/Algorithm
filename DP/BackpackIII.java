public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        if (A == null || V == null || m < 1) {
            return 0;
        }
        
        int len = A.length;
        int[][] memo = new int[len + 1][m + 1];
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                int k = 0;
                
                while (k * A[i - 1] <= j) {
                    memo[i][j] = Math.max(memo[i][j], 
                            memo[i - 1][j - k * A[i - 1]] + k * V[i - 1]);
                    k++;
                }
            }
        }
        
        return memo[len][m];
    }
}
