public class Solution {
    public int nthSuperUglyNumber(int n, int[] arr) {
        /*
        // Heap + HashSet
        // Time complexity: O(mn)     Space complexity: O(mn)
        // Use Long instead of Integer
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int len = arr.length;
        
        heap.offer(1L);
        set.add(1L);  
        
        for (int i = 0; i < len; i++) {
            heap.offer((long)arr[i]);
            set.add((long)arr[i]);    
        }
        
        while ((n - 1) > 0) {
            long num = heap.poll();
            
            for (int i = 0; i < len; i++) {
                if (set.add(num * arr[i])) {
                    heap.offer(num * arr[i]);
                }    
            }
            
            n--;
        }
        
        return (int)((long)heap.poll());
        */ 
        
        // DP
        // Time complexity: O(n)     Space complexity: O(n)
        int len = arr.length;
        int[] memo = new int[n + 1];
        int[] indexes = new int[len];
        int[] vals = new int[len];
        
         memo[1] = 1;
        for (int i = 0; i < len; i++) {
            vals[i] = arr[i];
            indexes[i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            // Get min val and its index
            for (int j = 0; j < len; j++) {
                if (min > vals[j]) {
                    min = vals[j]; 
                    index = j;
                }
            }
            
            memo[i] = min;
            
            for (int j = 0; j < len; j++) {
                if (vals[j] == min) {
                    vals[j] = arr[j] * (memo[++indexes[j]]);
                }
            }
        }
        
        return memo[n];
    }
}
