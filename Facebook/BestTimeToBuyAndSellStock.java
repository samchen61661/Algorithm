public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int len = prices.length;
        int max = 0;
        int min = prices[0];
        
        for (int i = 1; i < len; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            }
            
            min = Math.min(min, prices[i]);
        }
        
        return max;
    }
}
