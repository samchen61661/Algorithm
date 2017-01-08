public class Solution {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        if (nums == null || target < 1) {
            return 0;
        }
        
        int len = nums.length;
        int[][] memo = new int[2][target + 1];
        
        memo[0][0] = 1;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                
                if (j >= nums[i - 1]) {
                    memo[i % 2][j] += memo[(i - 1) % 2][j - nums[i - 1]];
                }
            }
        }
        
        return memo[len % 2][target];
    }
}
