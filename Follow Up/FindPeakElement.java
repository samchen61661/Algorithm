class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // Binary Search
        if (A == null || A.length < 3) {
            return -1;
        }
        
        int len = A.length;
        int left = 1;
        int right = len - 2;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
                
            } else if (A[mid - 1] <= A[mid]) {
                left = mid;
                
            } else {
                right = mid;
            }
        }
        
        if (A[left] > A[left + 1]) {
            return left;
        }
        
        return right;
    }
}
