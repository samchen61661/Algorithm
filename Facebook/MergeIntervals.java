/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // Time Complexity: O(nlogn)    Space Complexity: O(n)
        List<Interval> res = new ArrayList<>();
        
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare (Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        int size = intervals.size();
        Interval i1 = intervals.get(0);
        
        
        for (int i = 1; i < size; i++) {
            Interval i2 = intervals.get(i);
            
            if (i1.end >= i2.start) {
                i1.end = Math.max(i1.end, i2.end);
                
            } else {
                res.add(i1);
                i1 = i2;
            }
        }
        
        res.add(i1);
        
        return res;
    }
}
