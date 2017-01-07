class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        if (A == null || A.length < 1) {
            return;
        }
        
        int len = A.length;
        int negCnt = 0;
        int posCnt = 0;
        int negIdx = 0;
        int posIdx = 1;
        
        for (int num : A) {
            if (num < 0) {
                negCnt++;    
            } else {
                posCnt++;
            }
        }
        
        if (posCnt > negCnt) {
            negIdx = 1;
            posIdx = 0;
        }
        
        while (negIdx < len && posIdx < len) {
            while (negIdx < len && A[negIdx] < 0) {
                negIdx += 2;
            }
            
            while (posIdx < len && A[posIdx] > 0) {
                posIdx += 2;
            }
            
            if (negIdx < len && posIdx < len) {
                swap(A, negIdx, posIdx);
                negIdx += 2;
                posIdx += 2;
            }
        }
   }
   
   private void swap (int[] A, int i, int j) {
       int tmp = A[i];
       A[i] = A[j];
       A[j] = tmp;
   }
}
