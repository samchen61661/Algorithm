public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int lenS = s.length();
        int lenP = p.length();
        
        boolean[][] memo = new boolean[lenS + 1][lenP + 1];
        
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <= lenP; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = true;
                } else if (j == 0) {
                    memo[i][j] = false;
                } else if (p.charAt(j - 1) != '?' && p.charAt(j - 1) != '*') {
                    if (i > 0) {
                        memo[i][j] = memo[i - 1][j - 1] 
                                && (s.charAt(i - 1) == p.charAt(j - 1));
                    }
                } else if (p.charAt(j - 1) == '?') {
                    if (i > 0) {
                        memo[i][j] = memo[i - 1][j - 1];
                    }
                } else {
                    for (int k = i; k >= 0; k--) {
                        if (memo[k][j - 1]) {
                            memo[i][j] = true;
                            break;
                        }
                        
                        memo[i][j] = false;
                    }
                    
                }
            }
        }
        
        return memo[lenS][lenP];
    }
}
