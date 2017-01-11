public class Solution {
    /**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        if (A == null || A.length == 0 || k < 1 || k >= A.length) {
            return 0;
        }
        
        // In order to get the min range distance
        Arrays.sort(A);
        
        int len = A.length;
        int[][] memo = new int[len + 1][k + 1];
        int[][] dis = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int mid = (i + j) / 2;
                
                for (int m = i; m <= j; m++) {
                    dis[i][j] += Math.abs(A[m] - A[mid]);
                }
            }
        }
        
        for (int i = 1; i <= len; i++) {
            memo[i][1] = dis[0][i - 1];
        }
        
        for (int j = 2; j <= k; j++) {
            // the number of houses should be more than the number of offices
            for (int i = j + 1; i <= len; i++) {
                memo[i][j] = Integer.MAX_VALUE;
                
                // the number of houses in the previous partition should be
                // more than (the number of offices - 1)
                for (int m = j - 1; m < i; m++) {
                    memo[i][j] = Math.min(memo[i][j], 
                            memo[m][j - 1] + dis[m][i - 1]);    
                }
            }
        }
        
        return memo[len][k];
    }
}
