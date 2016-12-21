public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int left = 1;
        int right = len - 2;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int max = 0;
        
        while (left <= right) {
            if (leftMax < rightMax) {
                max += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                max += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        
        return max;
    }
}
