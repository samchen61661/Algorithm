public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        
        /*
        // Union Find + HashMap
        // Time complexity: O(N)    Space complexity: O(N)
        
        UnionFind uf = new UnionFind(len);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            
            map.put(nums[i], i + 1);   // index in the Union Find: i + 1
            
            if (map.containsKey(nums[i] - 1)) {
                uf.union(i + 1, map.get(nums[i] - 1));   // index in the Union Find: i + 1
            }
            
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i + 1, map.get(nums[i] + 1));   // index in the Union Find: i + 1
            }
        }
        
        return uf.getMaxCount();
        */
        
        /*
        // HashMap
        // Time complexity: O(N)    Space complexity: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            
            int leftCount = (map.get(num - 1) == null) ? 0 : map.get(num - 1);
            int rightCount = (map.get(num + 1) == null) ? 0 : map.get(num + 1);
            
            int sum = leftCount + rightCount + 1;
        
            max = Math.max(max, sum);
            
            map.put(num, sum);
            map.put(num - leftCount, sum);
            map.put(num + rightCount, sum);
        }
        
        return max;
        */
        
        // HashSet
        // Time complexity: O(N)    Space complexity: O(N)
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int num : nums) {
            // Avoid duplicates
            if (set.remove(num)) {
                int delta = 1;
                int sum = 0;
                
                while (set.remove(num - delta)) {
                    delta++;
                }
                sum += delta;
                
                delta = 1;
                while (set.remove(num + delta)) {
                    delta++;
                }
                sum += delta - 1;
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}

class UnionFind {
    private int[] father;
    private int[] count;
    
    public UnionFind (int size) {
        father = new int[size + 1];
        count = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            father[i] = i;
            count[i] = 1;
        }
        
    }
    
    public int find (int a) {
        if (a == father[a]) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
    
    public void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count[rootB] += count[rootA];
        }
    }
    
    public int getMaxCount() {
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
            System.out.println(c);
        }
        return max;
    }
}
