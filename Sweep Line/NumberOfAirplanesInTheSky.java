/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        int count = 0;
        int max = 0;
        int len = airplanes.size();
        
        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();
        
        for (Interval interval : airplanes) {
            startTime.add(interval.start);
            endTime.add(interval.end);
        }
        
        Collections.sort(startTime);
        Collections.sort(endTime);
        
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < len) {
            if (startTime.get(startIndex) < endTime.get(endIndex)) {
                count++;
                max = Math.max(max, count);
                startIndex++;
            } else {
                count--;
                endIndex++;
            }
        }
        
        return max;
    }
}
