public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if (A == null || A.length == 0) {
            return res;    
        }
        
        int len = A.length;
        
        int max = A[0];
        int min = A[0];
        
        int startIdx = 0;
        int endIdx = 0;
        int sum = A[0];
        int totalSum = A[0];
        
        int start = 0;
        int end = 0;
        
        // Find max subarray
        for (int i = 1; i < len; i++) {
            totalSum += A[i];
            
            if (sum < 0) {
                sum = A[i];
                startIdx = i;

            } else {
                sum += A[i];
            }
            
            endIdx = i;
            
            if (max < sum) {
                max = sum;
                start = startIdx;
                end = endIdx;
            }
        }
        
        // Find min subarray
        sum = A[0];
        startIdx = 0;
        endIdx = 0;
        
        for (int i = 1; i < len; i++) {
            if (sum > 0) {
                sum = A[i];
                startIdx = i;

            } else {
                sum += A[i];
            }
            
            endIdx = i;
            
            if (min > sum) {
                min = sum;
                
                // Corner case: all negative numbers in the array
                if (totalSum - min > max 
                        && !(startIdx == 0 && endIdx == len - 1)) {
                    start = (endIdx + 1) % len;
                    end = (startIdx - 1) % len;
                }
            }
        }
        
        res.add(start);
        res.add(end);
        
        return res;
    }
}
