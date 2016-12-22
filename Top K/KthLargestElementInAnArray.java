public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len < 1 || k < 1) {
            return 0;
        }
        /*
        // Quick Selection
        // Average time complexity: O(n)  Worst time complexity: O(n^2)
        return quickSelection(nums, 0, len - 1, len - k);
        */
        
        // Heap
        // Time complexity: O(nlogk)     Space complexity: O(k)
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);   // Minimum heap
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.poll();
    }
 
    private int quickSelection (int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }    
        
        int position = partition(nums, left, right);
        
        if (position == k) {
            return nums[position];
        } else if (position < k) {
            return quickSelection(nums, position + 1, right, k);
        } else {
            return quickSelection(nums, left, position - 1, k);
        }
    }
    
    private int partition (int[] nums, int l, int r) {
        int left = l;
        int right = r;
        int pivot = nums[left];
        
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        return left;
    }
}
