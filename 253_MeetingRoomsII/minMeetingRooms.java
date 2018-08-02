/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals based on start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // Create a priority that sort by end time
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval current = pq.poll();

            // can start after the current
            if (intervals[i].start >= current.end) {
                current.end = intervals[i].end;
            } else {
                // need a new room
                pq.offer(intervals[i]);
            }

            pq.offer(current);
        }

        return pq.size();
    }
}
