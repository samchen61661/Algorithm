public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
     
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // parameters: size, comparator
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, Collections.reverseOrder());
    
    public int[] medianII(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        // median is put in the maxHeap (in the fist half part)
        for (int i = 0; i < len; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            res[i] = maxHeap.peek();
        }
        
        return res;
    }
}
