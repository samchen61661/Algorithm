public class Solution {
    private String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        res.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            int size = res.size();
            
            for (int j = 0; j < size; j++) {
                String str = res.remove(0);
                
                for (int k = 0; k < strs[digits.charAt(i) - '0'].length(); k++) {
                    res.add(str + strs[digits.charAt(i) - '0'].charAt(k));
                }
            }
        }
        
        return res;
    }
}
