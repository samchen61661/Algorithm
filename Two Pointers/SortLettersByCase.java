public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length < 2) {
            return;
        }
        
        int len = chars.length;
        int left = 0;
        int right = len - 1;
        
        while (left <= right) {
            while (left <= right && chars[right] < 'a') {
                right--;
            }
            
            while (left <= right && chars[left] >= 'a') {
                left++;
            }
            
            if (left <= right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }
    }
    
    private void swap (char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
