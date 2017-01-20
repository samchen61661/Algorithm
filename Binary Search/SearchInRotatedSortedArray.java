public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int len = A.length;
        int left = 0;
        int right = len - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] == target) {
                return mid;
            }
            
            if (A[mid] < A[right]) {
                if (target >= A[mid] && target <= A[right]) {
                    left = mid;
                    
                } else {
                    right = mid;
                }
                
            } else {
                if (target >= A[left] && target <= A[mid]) {
                    right = mid;
                    
                } else {
                    left = mid;
                }
            }
        }
        
        if (A[left] == target) {
            return left;
            
        } else if (A[right] == target) {
            return right;
            
        } else {
            return -1;
        }
    }
}
