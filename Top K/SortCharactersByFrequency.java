public class Solution {
    public String frequencySort(String s) {
        /*
        // Bucket Sort 
        // Time complexity: O(n)    Space complexity: O(n)
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        List<Character>[] bucket = new List[len + 1];   // size: len + 1
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = (char)entry.getKey();
            int val = (int)entry.getValue();
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<Character>();
            }
            bucket[val].add(key);
        }
        
        for (int i = len; i >= 0; --i) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    for (int k = 0; k < i; k++) {
                        builder.append(bucket[i].get(j));
                    }
                }
            }
        }
        
        return builder.toString();
        */
        
        // Heap
        // Time complexity: O(nlogn)   Space complexity: O(n)
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        PriorityQueue<Pair> heap = new PriorityQueue<>(len + 1, new Comparator<Pair>(){  // Maximum heap & len != 0 
            @Override
            public int compare (Pair p1, Pair p2) {
                return p2.count - p1.count;
            }
        });
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = (char)entry.getKey();
            int val = (int)entry.getValue();
            heap.offer(new Pair(key, val));
        }
        
        while (!heap.isEmpty()) {
            Pair pair = heap.poll();
            char c = pair.c;
            int count = pair.count;
            for (int i = 0; i < count; i++) {
                builder.append(c);
            }
        }
        
        return builder.toString();
    }
}


class Pair {
    public char c;
    public int count;
    
    public Pair (char c, int count) {
        this.c = c;
        this.count = count;
    }
}
