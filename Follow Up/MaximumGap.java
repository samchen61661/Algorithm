class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int len = nums.length;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = -1;
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        if (min == max) {
            return 0;
        }
        
        int bufSize = (max - min) / len + 1;
        int bufNum = (max - min) / bufSize + 1;
        
        int[] minArr = new int[bufNum];
        int[] maxArr = new int[bufNum];
        
        for (int i = 0; i < bufNum; i++) {
            minArr[i] = Integer.MAX_VALUE;
            maxArr[i] = Integer.MIN_VALUE;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            int index = (num - min) / bufSize;
            
            set.add(index);
            
            minArr[index] = Math.min(minArr[index], num);
            maxArr[index] = Math.max(maxArr[index], num);
        }
        
        if (set.size() == 1) {
            return maxArr[0] - minArr[0];
        }
        
        int pre = 0;
        
        for (int i = 1; i < bufNum; i++) {
            if (set.contains(i)) {
                res = Math.max(res, minArr[i] - maxArr[pre]);
                pre = i;
            }
        }
        
        return res;
    }
}
