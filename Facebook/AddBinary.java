public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        
        StringBuilder builder = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int i = lenA - 1;
        int j = lenB - 1;
        int c = 0;
        
        while (i >= 0 || j >= 0) {
            int numA = (i >= 0) ? (a.charAt(i) - '0') : 0;
            int numB = (j >= 0) ? (b.charAt(j) - '0') : 0;
            int sum = numA + numB + c;
            
            // insert(offset, num)
            builder.insert(0, sum % 2);
            c = sum / 2;
            i--;
            j--;
        }
        
        if (c == 1) {
            builder.insert(0, c);
        }
        
        return builder.toString();
    }
}
