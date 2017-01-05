public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] memo = new int[nums.length];
        int max = 1;
        
        /*
        // DP
        // Time complexity: O(n^2)   Space complexity: O(n)
        for (int i = 0; i < len; i++) {
            memo[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }    
            }
            max = Math.max(max, memo[i]);
        }
        
        return max;
        */
        
        // Binary Search
        // Time complexity: O(nlogn)    Space complexity: O(n)
        for (int i = 0; i < len; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < len; i++) {
            memo[findIndex(memo, nums[i])] = nums[i]; 
        }
        
        for (int i = len - 1; i >= 0; i--) {
            if (memo[i] != Integer.MAX_VALUE) {
                max = i + 1;
                break;
            }
        }
        return max;
    }
    
    // Find the first number that it's bigger than "num" in array "memo". 
    private int findIndex (int[] memo, int num) {
        int left = 0; 
        int right = memo.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (memo[mid] < num) {
                left = mid + 1;
                
            } else if (memo[mid] == num) {
                return mid;
                
            } else if (memo[mid] > num) {
                if (mid > 0 && memo[mid - 1] < num) {
                    return mid;
                    
                } else {
                    right--;
                }
            }
        }
        
        return left;
    }
}
