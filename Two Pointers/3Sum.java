public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) {
            return res;
        }
        
        // Sort
        Arrays.sort(nums);
        
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = len - 1;
                
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                        
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        k--;
                        
                    } else if (sum < 0) {
                        j++;
                        
                    } else {
                        k--;
                    }
                }
            }
        }
        
        return res;
    }
}
