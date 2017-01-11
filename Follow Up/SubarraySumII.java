public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        if (A == null || A.length == 0 || start > end) {
            return 0;
        }
        
        int len = A.length;
        int[] preSum = new int[len + 1];
        int cnt = 0;
        
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }
        
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                int dif = preSum[j] - preSum[i];
                
                if (start <= dif && dif <= end) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
