public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackIV(int[] nums, int target) {
        /*
        if (nums == null || target < 1) {
            return 0;
        } 
        
        int len = nums.length;
        int[][] memo = new int[len + 1][target + 1];
        
        memo[0][0] = 1;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                int k = 0;
                
                while (k * nums[i - 1] <= j) {
                    memo[i][j] += memo[i - 1][j - k * nums[i - 1]];
                    k++;
                }
            }
        }
        
        return memo[len][target];
        */
        
        if (nums == null || target < 1) {
            return 0;
        } 
        
        int len = nums.length;
        int[][] memo = new int[2][target + 1];
        
        memo[0][0] = 1;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                int k = 0;
                
                while (k * nums[i - 1] <= j) {
                    memo[i % 2][j] += memo[(i - 1) % 2][j - k * nums[i - 1]];
                    k++;
                }
            }
            
            for (int j = 0; j < target + 1; j++) {
                memo[(i - 1) % 2][j] = 0;
            }
        }
        
        return memo[len % 2][target];
    }
}
