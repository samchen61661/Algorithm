public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        
        for (i = 0; i < len; i++) {
            while (j < len && set.add(s.charAt(j))) {
                j++;
                max = Math.max(max, j - i);
            }
            
            set.remove(s.charAt(i));
        }
        
        return max;
    }
}
