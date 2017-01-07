public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    if (nums == null || nums.length < 1) {
	        return 0;
	    }
	    
	    int len = nums.length;
	    int left = 0;
	    int right = len - 1;
	    
	    while (left <= right) {
	        while (left <= right && nums[right] >= k) {
	            right--;
	        }
	        
	        while (left <= right && nums[left] < k) {
	            left++;
	        }
	        //System.out.println(left + " " + right);
	        if (left <= right) {
	            swap(nums, left, right);
	            left++;
	            right--;
	        }
	        //System.out.println(left + " " + right);
	    }
	    
	    return left;
    }
    
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
