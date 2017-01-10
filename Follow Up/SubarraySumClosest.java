public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        
        if (nums == null || nums.length == 0) {
            return res;     
        }
        
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        ArrayList<Pair> list = new ArrayList<>();
        
        list.add(new Pair(nums[0], 0));
        
        for (int i = 1; i < len; i++) {
            list.add(new Pair(list.get(i - 1).sum + nums[i], i)); 
        }
        
        Collections.sort(list, new Comparator<Pair>(){
            public int compare (Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        });
        
        
        for (int i = 1; i < len; i++) {
            int diff = Math.abs(list.get(i - 1).sum - list.get(i).sum);
            
            if (min > diff) {
                min = diff;
                
                if (list.get(i - 1).index < list.get(i).index) {
                    res[0] = list.get(i - 1).index + 1;
                    res[1] = list.get(i).index;
                } else {
                    res[0] = list.get(i).index + 1;
                    res[1] = list.get(i - 1).index;
                }
            }
        }
        
        return res;
    }
}

class Pair {
    public int sum;
    public int index;
    
    public Pair (int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}
