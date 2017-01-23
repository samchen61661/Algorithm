class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (nums == null) {
            return res;
        }
        
        Arrays.sort(nums);
        
        /*
        // recursive
        helper(res, nums, 0, new ArrayList<Integer>());
        */
        
        
        // iterative
        int len = nums.length;
        
        for (int i = 0; i < Math.pow(2, len); i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int index = 0;
            
            int tmp = i;
            
            while (tmp != 0) {
                if (tmp % 2 == 1) {
                    list.add(nums[index]);
                }
                
                tmp /= 2;
                index++;
            }
            
            res.add(list);
        }
        
        return res;
    }
    
    private void helper (ArrayList<ArrayList<Integer>> res, int[] nums, 
            int idx, ArrayList<Integer> list) {
        // Create new list
        res.add(new ArrayList<Integer>(list));
        
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
