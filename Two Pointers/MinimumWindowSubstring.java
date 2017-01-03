public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source == null || target == null || target.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : source.toCharArray()) {
            map.put(c, 0);
        }
        
        for (char c : target.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                return "";
            }
            
        }
        
        int len = source.length();
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int i = 0;
        int j = 0;
        int count = target.length();
        
        for (i = 0; i < len; i++) {
            while (j < len && count > 0) {
                char c = source.charAt(j);
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
                j++;
            }
            
            if (count == 0) {
                if (minLen > j - i) {
                    minLen = j - i;
                    start = i;
                }
            }
            
            char c = source.charAt(i);
            map.put(c, map.get(c) + 1);
            if (map.get(c) > 0) {
                count++;
            }
        }
        
        return (start == -1) ? "" : source.substring(start, start + minLen);
        
    }
}
