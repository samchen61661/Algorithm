public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        
        // Sort
        Arrays.sort(nums);
        
        for (int i = 0; i < len - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                
                for (int j = i + 1; j < len - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int k = j + 1;
                        int l = len - 1;
                        
                        while (k < l) {
                            int sum = nums[i] + nums[j] + nums[k] + nums[l];
                            
                            if (sum == target) {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                list.add(nums[l]);
                                res.add(list);
                                
                                while (k < l && nums[k] == nums[k + 1]) {
                                    k++;
                                }
                                k++;
                                
                                while (k < l && nums[l] == nums[l - 1]) {
                                    l--;
                                }
                                l--;
                                
                            } else if (sum < target) {
                                k++;
                            } else {
                                l--;
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
