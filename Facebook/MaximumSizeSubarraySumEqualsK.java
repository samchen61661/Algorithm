public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // Time complexity: O(n)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] sum = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        sum[0] = nums[0];
        map.put(0, -1);
        
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        for (int i = 0; i < len; i++) {
            if (map.containsKey(sum[i] - k)) {
                int idx = map.get(sum[i] - k);
                max = Math.max(max, i - idx);
            }
            
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            }
        }
        
        return max;
    }
}
