public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || V == null || m < 1) {
            return 0;
        }
        
        int len = A.length;
        int[][] memo = new int[2][m + 1];
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                
                if (j >= A[i - 1]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], 
                            memo[(i - 1) % 2][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        
        return memo[len % 2][m];
    }
}
