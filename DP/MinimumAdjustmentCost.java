public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || target < 0 || A.size() == 0) {
            return 0;
        }
        
        int len = A.size();
        int col = 101;
        int[][] memo = new int[len][col];
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < col; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
         
        for (int i = 0; i < col; i++) {
            memo[0][i] = Math.abs(i - A.get(0));
        }
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < col; k++) {
                    if (Math.abs(k - j) <= target) {
                        memo[i][j] = Math.min(memo[i][j], 
                                memo[i - 1][k] + Math.abs(A.get(i) - j));
                    }
                }
            }
        }
        
        for (int i = 0; i < col; i++) {
            min = Math.min(min, memo[len - 1][i]);
        }
        
        return min;
    }
}
