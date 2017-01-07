public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        } 
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 != len2) {
            return false;
        }
        
        int[][][] memo = new int[len1][len1][len1 + 1];
        
        return checkScramble(s1, s2, 0, 0, len1, memo);
    }
    
    private boolean checkScramble (String s1, String s2, int index1, int index2, int len, int[][][] memo) {
        if (memo[index1][index2][len] == 1) {
            return true;
        }
        if (memo[index1][index2][len] == -1) {
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            memo[index1][index2][len] = 1;
            return true;
        }
        
        if (!isValid(s1, s2)) {
            memo[index1][index2][len] = -1;
            return false;
        }
        
        for (int i = 1; i < len; i++) {
            String subStr11 = s1.substring(0, i);
            String subStr12 = s1.substring(i);
            
            String subStr21 = s2.substring(0, i);
            String subStr22 = s2.substring(i);
            
            String subStr23 = s2.substring(0, s2.length() - i);
            String subStr24 = s2.substring(s2.length() - i);
            
            if (checkScramble(subStr11, subStr21, index1, index2, i, memo) 
                    && checkScramble(subStr12, subStr22, index1 + i, 
                    index2 + i, s1.length() - i, memo)) {
                memo[index1][index2][len] = 1;
                return true;            
            }
            
            if (checkScramble(subStr11, subStr24, index1, index2 + len - i, 
                    i, memo) 
                    && checkScramble(subStr12, subStr23, index1 + i, index2, 
                    len - i, memo)) {
                memo[index1][index2][len] = 1;
                return true;            
            }
        }
        
        memo[index1][index2][len] = -1;
        return false;
    }
    
    private boolean isValid (String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                
            } else {
                map.put(c, 1);
            }
        }
        
        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                
                if (map.get(c) < 0) {
                    return false;
                }
                
            } else {
                return false;
            }
        }
        
        return true;
    }
}
