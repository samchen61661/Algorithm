public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        
        // Corner case
        if (len == 1) {
            return nums[0];
        }
        
        int[] memo = new int[3];
        int max;
        memo[1] = nums[0];
        
        for (int i = 2; i < len; i++) {
            memo[i % 3] = Math.max(memo[(i - 1) % 3], memo[(i - 2) % 3] + nums[i - 1]);
        }
        max = memo[(len - 1) % 3];
        
        memo[0] = 0;
        memo[1] = nums[1];
        for (int i = 2; i < len; i++) {
            memo[i % 3] = Math.max(memo[(i - 1) % 3], memo[(i - 2) % 3] + nums[i]);
        }
        max = Math.max(max, memo[(len - 1) % 3]);
        
        return max;
    }
}
