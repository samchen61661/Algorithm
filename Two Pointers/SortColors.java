class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        int k = 0;
        
        while (k <= j) {
            if (nums[k] == 0) {
                swap(nums, i++, k++);
                
            } else if (nums[k] == 1) {
                k++;
                
            } else {
                swap(nums, j--, k);
            }
        }
    }
    
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
