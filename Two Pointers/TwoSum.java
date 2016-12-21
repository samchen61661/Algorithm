public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hash 
        // Time complexity: O(n) Space complexity: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i}; 
            }
            map.put(nums[i], i++);
        }
        
        return new int[]{-1, -1};
        
        /*
        // Sort + Two pointers 
        // Time complexity: O(nlgn) Space complexity: O(n)
        ArrayIndexComparator comparator = new ArrayIndexComparator(nums);
        Integer[] index = comparator.createIndexArray();
        Arrays.sort(index, comparator);   // merge sort
        Arrays.sort(nums);    // quick sort
        
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{index[left], index[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
        */
    }
}

class ArrayIndexComparator implements Comparator<Integer> {
    private final int[] arr;
    
    public ArrayIndexComparator (int[] arr) {
        this.arr = arr;
    }
    
    public Integer[] createIndexArray () {
        int len = arr.length;
        Integer[] index = new Integer[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        return index;
    }
    
    @Override
    public int compare (Integer i1, Integer i2) {
        return arr[i1] - arr[i2]; 
    }
} 
