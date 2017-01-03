public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = 1;
        int cntInc = 1;
        int cntDes = 1;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                cntInc++;
                max = Math.max(max, cntInc);
            } else {
                cntInc = 1;
            } 
            
            if (A[i - 1] > A[i]) {
                cntDes++;
                max = Math.max(max, cntDes);
            } else {
                cntDes = 1;
            }   
        }
        
        return max;
    }
}
