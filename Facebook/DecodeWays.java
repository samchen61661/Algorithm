public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int[] memo = new int[2];
        
        memo[len % 2] = 1;
        memo[(len - 1) % 2] = (s.charAt(len - 1) == '0') ? 0 : 1;
        
        for (int i = len - 2; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (c == '0') {
                memo[i % 2] = 0;
                
            } else {
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    memo[i % 2] = memo[(i + 1) % 2] + memo[(i + 2) % 2];  
                    
                } else {
                    memo[i % 2] = memo[(i + 1) % 2];
                }
            }
        }
        
        return memo[0];
    }
}
