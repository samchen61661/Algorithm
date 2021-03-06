/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        // Iterative
        Queue<NestedInteger> queue = new LinkedList<>();
        int sum = 0;
        int level = 1;
        
        for (NestedInteger nestedInteger : nestedList) {
            queue.offer(nestedInteger);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInteger = queue.poll();
                
                if (nestedInteger.isInteger()) {
                    sum += level * nestedInteger.getInteger();
                    
                } else {
                    for (NestedInteger integer : nestedInteger.getList()) {
                        queue.offer(integer);
                    }
                }
            }
            
            level++;
        }
        
        return sum;
        
        /*
        // Recursive
        return countSum(nestedList, 1);
        */
    }
    
    private int countSum (List<NestedInteger> nestedList, int level) {
        int sum = 0;
        
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * level;
            } else {
                sum += countSum(nestedInteger.getList(), level + 1);
            }
        }
        
        return sum;
    }
}
