public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) {
            return -1;
        }
        
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];   // locality
        
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = len - 1;
                
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    res = (Math.abs(target - sum) < Math.abs(target - res)) ? sum : res;
                    
                    if (sum == target) {
                        return target;
                    } else if (sum < target) {
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                    } else {
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        k--;
                    }
                }
            }
        }
        
        return res;
    }
}
