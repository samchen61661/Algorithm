public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        
        int left = 0;
        int right = len - 1;
        int max = 0;
        
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
}
