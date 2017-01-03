public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];
        int res = max;
        
        for (int i = 1; i < len; i++) {
            if (nums[i] != 0) {
                int tmp = max;
                max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
                min = Math.min(nums[i], Math.min(tmp * nums[i], min * nums[i]));
            } else {
                max = 0;
                min = 0;
            }
            
            res = Math.max(res, max);
        }
        
        return res;
    }
}
