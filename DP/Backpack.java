public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0 || m < 1) {
            return 0;
        }
        
        // function: memo[i][j] = memo[i - 1][j] OR 
        // memo[i][j] = memo[i - 1][j - A[i - 1]] 
        // if memo[i - 1][j - A[i - 1]] is true
        int len = A.length;
        boolean[][] memo = new boolean[2][m + 1];
        
        memo[0][0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                // Do not pick current item
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                
                // Pick current item if possible
                if (j >= A[i - 1] && memo[(i - 1) % 2][j - A[i - 1]]) {
                    memo[i % 2][j] = true;
                }
            }
        }
        
        for (int i = m; i >= 0; i--) {
            if (memo[len % 2][i]) {
                return i;
            }
        }
        
        return 0;
    }
}
