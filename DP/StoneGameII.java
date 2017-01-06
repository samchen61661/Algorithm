public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = 2 * A.length - 1;
        int[][] memo = new int[len][len];
        boolean[][] isVisited = new boolean[len][len];
        int[] sum = new int[len];
        int min = Integer.MAX_VALUE;
        
        sum[0] = A[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + A[i % A.length];
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    memo[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        /*
        // Recursion
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, search(memo, isVisited, sum, A, i, i + A.length - 1));
        }
        */
        
        // Iterative
        // l represents the distance from i to j
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len && (i + l - 1) < len; i++) {
                int j = i + l - 1;
                
                for (int k = i; k < j; k++) {
                    if (memo[i][k] + memo[k + 1][j] + sum[j] - sum[i] + A[i % A.length] < memo[i][j]) {  // A.length
                        memo[i][j] = memo[i][k] + memo[k + 1][j] + sum[j] 
                                - sum[i] + A[i % A.length];
                    }
                    
                }
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, memo[i][i + A.length - 1]);
        }
        
        return min;
    }
    
    private int search (int[][] memo, boolean[][] isVisited, int[] sum, int[] A,
            int i, int j) {
        if (isVisited[i][j]) {
            return memo[i][j];
        } 
        
        if (i == j) {
            memo[i][j] = 0;
            
        } else {
            for (int k = i; k < j; k++) {
                int tmp = search(memo, isVisited, sum, A, i, k) + 
                        search(memo, isVisited, sum, A, k + 1, j) 
                        + sum[j] - sum[i] + A[i % A.length];
                memo[i][j] = Math.min(memo[i][j], tmp);
            }
        }
        
        isVisited[i][j] = true;
        return memo[i][j];
    }
}
