public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i : L) {
            max = Math.max(max, i);
        }
        
        int left = 1;
        int right = max;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            int cnt = getCount(L, mid);
            
            if (cnt < k) {
                right = mid;
                
            } else {
                left = mid;
            }
        }
        
        if (getCount(L, right) >= k) {
            return right;
        } 
        if (getCount(L, left) >= k) {
            return left;
        }
        return 0;
    }
    
    private int getCount(int[] L, int num) {
        int cnt = 0;
        
        for (int i : L) {
            cnt += i / num;
        }
        
        return cnt;
        
    }
}
