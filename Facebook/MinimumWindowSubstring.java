public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }
        
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                
            } else {
                return "";
            }
        }
        
        int len = Integer.MAX_VALUE;
        int startIdx = -1;
        int cnt = t.length();
        int i = 0;
        int j = 0;
        
        for (i = 0; i < s.length(); i++) {
            while (cnt > 0 && j < s.length()) {
                char c = s.charAt(j);
                map.put(c, map.get(c) - 1);
                
                if (map.get(c) >= 0) {
                    cnt--;
                }
                j++;
            }
            
            if (cnt == 0) {
                if (len > j - i) {
                    len = j - i;
                    startIdx = i;
                }
                
                char c = s.charAt(i);
                map.put(c, map.get(c) + 1);
                
                if (map.get(c) > 0) {
                    cnt++;
                }
            }
        }
        
        return (len == Integer.MAX_VALUE) ? "" : s.substring(startIdx, startIdx + len);
    }
}
