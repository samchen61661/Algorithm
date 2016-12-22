public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        // Bucket Sort
        // Time complexity: O(n)          Space complexity: O(n)
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // the way to new an array of lists 
        List<Integer>[] bucket = new List[len + 1];   // list size: len + 1   
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<Integer>();
            }
            bucket[val].add(key);
        }
        
        for (int i = len; i >= 0 && res.size() < k; --i) {   // i = len
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && res.size() < k; j++) {
                    res.add(bucket[i].get(j));
                }
            }
        }
        
        return res;
        */
        
        // Heap
        // Time complexity: O(nlogk)      Space complexity: O(k)
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(k, new Comparator<Pair>(){   // Minimum heap
            @Override
            public int compare (Pair p1, Pair p2) {
                return p1.count - p2.count;
            }
        });
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            
            if (heap.size() < k) {
                heap.offer(new Pair(key, val));
                
            } else {
                if (heap.peek().count < val) {
                    heap.poll();
                    heap.offer(new Pair(key, val));
                }
            }
        }
        
        while (!heap.isEmpty()) {
            res.add(heap.poll().num);
        }
        
        return res;
    }
}

class Pair {
    public int num;
    public int count;
    
    public Pair (int num, int count) {
        this.num = num;
        this.count = count;
    }
}
