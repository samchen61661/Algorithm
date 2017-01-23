class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (nums == null) {
            return res;
        }
        
        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList<Integer>());
        
        return res;
    }
    
    private void helper (ArrayList<ArrayList<Integer>> res, int[] nums, 
            int idx, ArrayList<Integer> list) {
        // Create new list
        res.add(new ArrayList<Integer>(list));
        
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            
            list.add(nums[i]);
            helper(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
