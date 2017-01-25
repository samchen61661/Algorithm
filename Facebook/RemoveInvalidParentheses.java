public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // BFS
        List<String> res = new ArrayList<>();
        
        if (s == null) {
            return res;
        }
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        boolean found = false;
        queue.offer(s);
        set.add(s);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (checkValid(str)) {
                    found = true;
                    res.add(str);
                    
                } else {
                    if (found) {
                        continue;
                    }
                    
                    for (int j = 0; j < str.length(); j++) {
                        if (s.charAt(j) == '(' || s.charAt(j) == ')') { 
                            String candidate = str.substring(0, j) + str.substring(j + 1);
                        
                            if (set.add(candidate)) {
                                queue.offer(candidate);
                            }
                        }
                    }
                }
            }
            
            if (found) {
                break;
            }
        }
        
        return res;
    }
    
    private boolean checkValid (String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                cnt++;
            } else if (c == ')'){
                if (cnt < 1) {
                    return false;
                }
                
                cnt--;
            }
        }
        
        return cnt == 0;
    }
    
}
