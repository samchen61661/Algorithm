class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) {
            return 0;
        } 
        
        int len = prices.length;
        if (k >= len / 2) {
            int sum = 0;
            for (int i = len - 1; i > 0; i--) {
                if (prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }
        
        int[][] local = new int[len + 1][k + 1];
        int[][] global = new int[len + 1][k + 1];
        
        for (int i = 2; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                int dif = prices[i - 1] - prices[i - 2];
                local[i][j] = Math.max(local[i - 1][j] + dif, 
                        global[i - 1][j - 1] + dif);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        
        return global[len][k];
    }
};
