public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || k < 1 || nums.length < k) {
            return res;
        }
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            
            deque.offerLast(nums[i]);
            
            if (i >= k - 1) {
                res.add(deque.peekFirst());
                
                if (deque.peekFirst() == nums[i - k + 1]) {
                    deque.pollFirst();
                }
            }
            
            
        }
        
        return res;
    }
}
