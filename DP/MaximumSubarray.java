public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int max =  Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
                max = Math.max(max, sum);
            } else {
                sum = num;
            }
        }
        
        return max;
    }
}
