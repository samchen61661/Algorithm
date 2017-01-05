public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        int len = values.length;
        
        int[][] memo = new int[len][len];
        boolean[][] isVisited = new boolean[len][len];
        
        /*
        // Version 1
        // from the aspect of current player
        int[] sum = new int[len];
        sum[0] = values[0];
        
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + values[i];
        }
        
        return sum[len - 1] / 2 < search1(memo, values, sum, isVisited, 0, len - 1);
        */
        
        // Version 2
        // from the aspect of first player
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        
        return sum / 2 < search2(memo, values, isVisited, 0, len - 1);
    }
    
    private int search2 (int[][] memo, int[] values, boolean[][] isVisited, 
            int left, int right) {
        if (left > right) {
            return 0;
        }
        
        int len = values.length;
        if (isVisited[left][right]) {
            return memo[left][right];
        }
        
        if (left == right) {
            memo[left][right] = values[left];
            
        } else if (right == left + 1) {
            memo[left][right] = Math.max(values[left], values[right]);
            
        } else {
            int pickLeft = values[left] + Math.min(
                    search2(memo, values, isVisited, left + 1, right - 1), 
                    search2(memo, values, isVisited, left + 2, right));
            int pickRight = values[right] + Math.min(
                    search2(memo, values, isVisited, left + 1, right - 1), 
                    search2(memo, values, isVisited, left, right - 2));
                    
            memo[left][right] = Math.max(pickLeft, pickRight);
        }
        
        isVisited[left][right] = true;
        return memo[left][right];
    }
    
    private int search1 (int[][] memo, int[] values, int[] sum, 
            boolean[][] isVisited, int left, int right) {
        if (left > right) {
            return 0;
        }
        
        int len = values.length;
        if (isVisited[left][right]) {
            return memo[left][right];
        }
        
        if (left == right) {
            memo[left][right] = values[left];
            
        } else if (right == left + 1) {
            memo[left][right] = Math.max(values[left], values[right]);
            
        } else {
            int rangeSum = sum[right] - sum[left] + values[left];
            int pickLeft = rangeSum - search1(memo, values, sum, isVisited, left + 1, right);
            int pickRight = rangeSum - search1(memo, values, sum, isVisited, left, right - 1);
            
            memo[left][right] = Math.max(pickLeft, pickRight);
        }
        
        isVisited[left][right] = true;
        return memo[left][right];
    }
}
