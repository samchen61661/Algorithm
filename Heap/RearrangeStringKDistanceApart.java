public class Solution {
    public String rearrangeString(String str, int k) {
        // Greedy + Heap
        // Time complexity: O(nlogk)    Space complexity: O(k)
        // n is the length of str; k is the number of distinct characters in str.
        if (str == null || k < 0) {
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Max heap
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(
                map.size(), new Comparator<Map.Entry<Character, Integer>>(){
            @Override 
            public int compare (Map.Entry<Character, Integer> entry1, 
                    Map.Entry<Character, Integer> entry2) {
                return  (entry2.getValue() - entry1.getValue());
            }
        });
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.offer(entry);
        }
        
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.poll();
            builder.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            queue.offer(entry);
            
            if (queue.size() < k) {
                continue;
            }
            
            
            Map.Entry<Character, Integer> addEntry = queue.poll();
            if (addEntry.getValue() != 0) {
                heap.offer(addEntry);
            }
        }
        
        return (builder.length() == str.length()) ? builder.toString() : "";
    }
}
