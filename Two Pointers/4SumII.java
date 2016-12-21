public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // Hash
        // Time complexity: O(n^2)   Space complexity: O(n^2)  
        // n: maximum length among arrays
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        
        for (int c : C) {
            for (int d : D) {
                count += map.getOrDefault(-c -d, 0);
            }
        }
        
        return count;
    }
}
