public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        if (A == null || B == null) {
            return Integer.MAX_VALUE;
        }
        
        int lenA = A.length;
        int lenB = B.length;
        if (lenA == 0 || lenB == 0) {
            return Integer.MAX_VALUE;
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < lenA && j < lenB) {
            min = Math.min(min, Math.abs(A[i] - B[j]));
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return min;
    }
}
