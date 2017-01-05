public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Time complexity: O(n^2)   Space complexity: O(1)
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int len = s.length();
        String res = s.substring(0, 1);
        String palindrom;
        
        for (int i = 0; i < len; i++) {
            palindrom = findPalindrom(s, i, i);
            if (res.length() < palindrom.length()) {
                res = palindrom;
            }
            
            palindrom = findPalindrom(s, i, i + 1);
            if (res.length() < palindrom.length()) {
                res = palindrom;
            }
        }
        
        return res;
    }
    
    private String findPalindrom (String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(++i, j);
    }
}
