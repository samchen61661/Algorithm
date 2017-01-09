public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int len = nums.length + 2;
        int[] val = new int[len];
        boolean[][] isVisited = new boolean[len][len];
        int[][] memo = new int[len][len];
        
        val[0] = 1;
        val[len - 1] = 1;
        
        for (int i = 1; i < len - 1; i++) {
            val[i] = nums[i - 1];
        }
        
        return search(val, isVisited, memo, 1, len - 2);
    }
    
    private int search(int[] val, boolean[][] isVisited, int[][] memo, int left, 
            int right) {
        if (left > right) {
            return 0;
        }
        if (isVisited[left][right]) {
            return memo[left][right];
        }
        
        int max = 0;
        
        for (int i = left; i <= right; i++) {
            int midVal = val[left - 1] * val[i] * val[right + 1];
            int leftVal = search(val, isVisited, memo, left, i - 1);
            int rightVal = search(val, isVisited, memo, i + 1, right);
            max = Math.max(max, 
                    midVal + leftVal + rightVal);
        }  
        
        isVisited[left][right] = true;
        memo[left][right] = max;
        return memo[left][right];
    }
}
