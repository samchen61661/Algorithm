public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int pivot = nums[len - 1];
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < pivot) {
                right = mid;
                
            } else {
                left = mid;
            }
        }
        
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        
        return nums[right];
    }
}
