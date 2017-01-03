public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        long[] memo = new long[3];
        memo[1] = A[0];
        
        for (int i = 2; i <= len; i++) {
            memo[i % 3] = Math.max(memo[(i - 1) % 3], memo[(i - 2) % 3] + A[i - 1]);
        }
        return memo[len % 3];
    }
}
