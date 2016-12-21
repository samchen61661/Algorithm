public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum < target) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return count;
    }
}
