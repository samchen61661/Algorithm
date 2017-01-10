public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        int[][] res = new int[2][2];
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;    
        }
        
        int row =  matrix.length;
        int col = matrix[0].length;
        
        int[][] preSum = new int[row + 1][col];
        
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < col; j++) {
                preSum[i][j] = preSum[i - 1][j] + matrix[i - 1][j];
            }
        }
        
        for (int i = 0; i <= row; i++) {
            for (int j = i + 1; j <= row; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);
                int sum = 0;
                
                for (int k = 0; k < col; k++) {
                    sum += preSum[j][k] - preSum[i][k];
                    
                    if (map.containsKey(sum)) {
                        res[0][0] = i;
                        res[0][1] = map.get(sum) + 1;
                        res[1][0] = j - 1;
                        res[1][1] = k;
                        
                        return res;
                    } 
                    
                    map.put(sum, k);
                }
            }
        }
        
        return res;
    }
}
