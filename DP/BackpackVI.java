public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] memo = new int[target + 1];
        memo[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len; j++) {
                
                if (i >= nums[j]) {
                    memo[i] += memo[i - nums[j]]; 
                }
            }
        }
        
        return memo[target];
    }
}
