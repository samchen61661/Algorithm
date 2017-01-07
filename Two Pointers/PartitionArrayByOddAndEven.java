public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null) {
            return;
        }
        
        int len = nums.length;
        
        int i = 0; 
        int j = len - 1;
        
        while (i <= j) {
            while (i <= j && (nums[i] % 2 == 1)) {
                i++;
            }
            while (i <= j && (nums[j] % 2 == 0)) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++; 
                j--;
            }
        }
    }
    
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
