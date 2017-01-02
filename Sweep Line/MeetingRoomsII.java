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
    public int minMeetingRooms(Interval[] intervals) {
        // Sweep Line
        // Time Complexity: O(nlogn)    Space Complexity: O(n)
        if (intervals == null) {
            return 0;
        }
        
        int cnt = 0;
        int max = 0;
        List<Point> list = new ArrayList<>();
        for (Interval interval : intervals) {
            list.add(new Point(0, interval.start));
            list.add(new Point(1, interval.end));
        }
        
        Collections.sort(list, new Comparator<Point>(){
            @Override
            public int compare (Point p1, Point p2) {
                // if indexes are the same, the end point comes first
                // Example: [[13,15],[1,13]] --> res: 1
                return (p1.index == p2.index) ? 
                        (p2.type - p1.type) : (p1.index - p2.index);
            }
        });
        
        for (Point point : list) {
            if (point.type == 0) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt--;
            }
        }
        
        return max;
    }
}

class Point {
    // type: 0 --> start point   1 --> end point
    public int type;
    public int index;
    
    public Point (int type, int index) {
        this.type = type;
        this.index = index;
    }
}
