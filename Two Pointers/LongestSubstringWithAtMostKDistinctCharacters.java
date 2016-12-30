public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k < 1) {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int max = 0;
        
        for (i = 0; i < len; i++) {
            while (j < len && !(map.size() == k && 
                    !map.containsKey(s.charAt(j)))) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                } else {
                    map.put(s.charAt(j), 1);
                }
                j++;
                max = Math.max(max, j - i);
            }
            
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if (map.get(s.charAt(i)) == 0) {
                map.remove(s.charAt(i));
            }
        }
        
        return max;
    }
}
