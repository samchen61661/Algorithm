public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int len = s.length();
        int i = 0;
        int j = len - 1;
        char c;
        
        while (i < j) {
            c = s.charAt(i);
            while (i < j && !(Character.isDigit(c) || Character.isLetter(c))) {
                c = s.charAt(++i);
            }
            
            c = s.charAt(j);
            while (i < j && !(Character.isDigit(c) || Character.isLetter(c))) {
                c = s.charAt(--j);
            }
            
            if (Character.toLowerCase(s.charAt(i)) 
                    != Character.toLowerCase(s.charAt(j))) {
                return false;
            } 
            
            i++;
            j--;
        }
        
        return true;
    }
}
