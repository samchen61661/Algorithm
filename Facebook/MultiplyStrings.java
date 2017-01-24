public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null 
                || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }    
        
        StringBuilder builder = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }    
        }
        
        int c = 0;
        
        for (int i = res.length - 1; i >= 0; i--) {
            // c should be added
            int tmp = res[i] + c;
            res[i] = (tmp % 10);
            c = tmp / 10;
        }
        
        int idx = 0;
        
        while (idx < res.length) {
            if (res[idx] == 0) {
                idx++;
            } else {
                break;
            }
        }
        
        if (idx == res.length) {
            return "0";
        }
        
        while (idx < res.length) {
            builder.append(res[idx++]);
        }
        
        return builder.toString();
    }
}
