class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        
        if (x == 1) {
            return 1;
        }
        
        int left = 1;
        int right = x;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (x / mid < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        // x should be less than or equal to left * left
        if (x / left >= left) {
            return left;
        }
        
        return right;
    }
}
