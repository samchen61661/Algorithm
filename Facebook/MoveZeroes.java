public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int len = nums.length;
        int i;
        int j = 0;
        
        for (i = 0; i < len; i++) {
            while (j < len && nums[j] == 0) {
                j++;
            }
            
            if (j < len) {
                nums[i] = nums[j];
                j++;
                
            } else {
                nums[i] = 0;    
            }
        }
    }
}
