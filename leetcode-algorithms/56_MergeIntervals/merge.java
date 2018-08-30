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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Interval current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval target = intervals.get(i);

            if (current.end >= target.start) {
                current.end = Math.max(current.end, target.end);
            } else {
                result.add(current);
                current = target;
            }
        }

        result.add(current);

        return result;
    }
}
