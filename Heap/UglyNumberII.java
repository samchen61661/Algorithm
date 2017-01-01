public class Solution {
    public int nthUglyNumber(int n) {
        /*
        // Heap + HashSet
        // Time complexity: O(nlogn)    Space complexity: O(n)
        // Use Long instead of Integer
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        final long[] arr = {2, 3, 5};
        
        heap.offer(1L);
        set.add(1L);  
        
        for (int i = 0; i < 3; i++) {
            heap.offer(arr[i]);
            set.add(arr[i]);    
        }
        
        while ((n - 1) > 0) {
            long num = heap.poll();
            
            for (int i = 0; i < 3; i++) {
                if (set.add(num * arr[i])) {
                    heap.offer(num * arr[i]);
                }    
            }
            
            n--;
        }
        
        return (int)((long)heap.poll());
        */
        
        // DP
        // Time complexity: O(n)    Space complexity: O(n)
        int[] memo = new int[n + 1];
        memo[1] = 1;
        
        int val2 = 2;
        int val3 = 3;
        int val5 = 5;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        
        for (int i = 2; i <= n; i++) {
            int min = Math.min(val2, Math.min(val3, val5));
            memo[i] = min;
            if (min == val2) {
                val2 = 2 * memo[++index2];
            }
            if (min == val3) {
                val3 = 3 * memo[++index3];
            }
            if (min == val5) {
                val5 = 5 * memo[++index5];
            }
        }
        
        return memo[n];
    }
}
