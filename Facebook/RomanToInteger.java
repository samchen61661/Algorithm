public class Solution {
    private final char[] ROMANS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private final int[] VALUES = {1, 5, 10, 50, 100, 500, 1000};
    
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int sum = 0;
        int i = 0;
        
        while (i < len - 1) {
            int val1 = getVal(s.charAt(i));
            int val2 = getVal(s.charAt(i + 1));
            
            if (val1 < val2) {
                sum += val2 - val1;
                i += 2;
                
            } else {
                sum += val1;
                i++;
            }
        }
        
        if (i == len - 1) {
            sum += getVal(s.charAt(len - 1));
        }
        
        return sum;
    }
    
    private int getVal (char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
