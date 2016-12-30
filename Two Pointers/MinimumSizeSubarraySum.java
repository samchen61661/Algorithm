public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if (nums == null) {
            return -1;
        } 
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        
        for (i = 0; i < len; i++) {
            while (j < len && sum < s) {
                sum += nums[j++];
            }
            
            if (sum >= s) {
                min = Math.min(min, j - i);
            }
            sum -= nums[i];
        }
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
