public class Solution {
    public int thirdMax(int[] nums) {
        // Trick: use Long.MIN_VALUE instead of Integer.MAX_VALUE 
        long max = Long.MIN_VALUE;
        long mid = Long.MIN_VALUE;
        long min = Long.MIN_VALUE;
       
        for (int num : nums) {
            if (num == max || num == mid || num == min) {
                continue;
            }
            if (num > max) {
                min = mid;
                mid = max;
                max = num;
                
            } else if (num > mid){
                min = mid; 
                mid = num;
                
            } else if (num > min){
                min = num;
                
            }
        }
        
        if (min != Long.MIN_VALUE) {
            return (int)min;
        } 
        return (int)max;
        
    
    }
}
