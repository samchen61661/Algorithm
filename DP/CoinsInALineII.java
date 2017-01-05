public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null) {
            return false;
        }
        
        
        int len = values.length;
        int[] memo = new int[len + 1];
        boolean[] isVisited = new boolean[len + 1];
        
        // Version 1
        // from the aspect of current player
        int[] sum = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + values[i];
        }
        
        return sum[0] / 2 < search1(values, memo, isVisited, sum, len);
        
        /*
        // Version 2
        // from the aspect of first player
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        
        return sum / 2 < search2(values, memo, isVisited, len);
        */
    }
    
    private int search2 (int[] values, int[] memo, boolean[] isVisited, int n) {
        int len = values.length;
        if (n < 0) {
            return 0;
        }
        if (isVisited[len - n]) {
            return memo[len - n];
        }
        
        if (n == 0) {
            memo[len - n] = 0;
        } else if (n == 1) {
            memo[len - n] = values[len - 1];
        } else if (n == 2) {
            memo[len - n] = values[len - 1] + values[len - 2];
        } else {
            memo[len - n] = values[len - n] + Math.max(
                    Math.min(search2(values, memo, isVisited, n - 2), 
                    search2(values, memo, isVisited, n - 3)), 
                    values[len - n + 1] 
                    + Math.min(search2(values, memo, isVisited, n - 3), 
                    search2(values, memo, isVisited, n - 4)));
        }
        
        isVisited[len - n] = true;
        return memo[len - n];
    }
    
    private int search1 (int[] values, int[] memo, boolean[] isVisited, int[] sum, 
            int n) {
        int len = values.length;
        
        if (isVisited[len - n]) {
            return memo[len - n];
        }
        
        if (n <= 0) {
            memo[len - n] = 0;
            
        } else if (n == 1) {
            memo[len - n] = values[len - 1];
            
        } else if (n == 2) {
            memo[len - n] = values[len - 1] + values[len - 2];
            
        } else {
            memo[len - n] = sum[len - n] - Math.min(
                    search1(values, memo, isVisited, sum, n - 1), 
                    search1(values, memo, isVisited, sum, n - 2));
            
        }
        isVisited[len - n] = true;
        return memo[len - n];
    }
}
