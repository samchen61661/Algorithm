public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        int[][] memo = new int[len][len];
        boolean[][] isVisited = new boolean[len][len];
        int[] sum = new int[len];
        sum[0] = A[0];
        
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + A[i];     
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
         
        return search(A, memo, isVisited, sum, 0, len - 1);
    }
    
    private int search (int[] A, int[][] memo, boolean[][] isVisited, int[] sum,
            int i, int j) {
        if (isVisited[i][j]) {
            return memo[i][j];
        }
        if (i == j) {
            memo[i][j] = 0;
        } else {
            for (int k = i; k < j; k++) {
                int tmp = search(A, memo, isVisited, sum, i, k) + search(A, memo, isVisited, sum, k + 1, j) + sum[j] - sum[i] + A[i];
                memo[i][j] = Math.min(tmp, memo[i][j]); 
            }
        }
        
        isVisited[i][j] = true;
        return memo[i][j];
    }
}
