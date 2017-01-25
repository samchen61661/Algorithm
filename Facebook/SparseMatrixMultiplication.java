public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 
                || B == null || B.length == 0 || B[0].length == 0) {
            return new int[][]{};        
        }
        
        int m = A.length;
        int n = B[0].length;
        int k = A[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int l = 0; l < k; l++) {
                if (A[i][l] != 0) {
                    
                    for (int j = 0; j < n; j++) {
                        if (B[l][j] != 0) {
                            res[i][j] += A[i][l] * B[l][j];
                        }
                        
                    }
                }
            }
        }
        
        return res;
    }
}
