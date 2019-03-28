package Page2;

import tools.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
* */
public class N56_MergeIntervals {

    public static void main(String[] args) {
        // [[4,5],[2,4],[4,6],[3,4],[0,0],[1,1],[3,5],[2,2]]
        List<Interval> listss = new ArrayList<>();
        listss.add(new Interval(4, 5));
        listss.add(new Interval(2, 4));
        listss.add(new Interval(4, 6));
        listss.add(new Interval(3, 4));
        listss.add(new Interval(0, 0));
        listss.add(new Interval(1, 1));
        listss.add(new Interval(3, 5));
        listss.add(new Interval(2, 2));
        List<Interval> lists = new N56_MergeIntervals().merge(listss);
        for (Interval a : lists
             ) {
            System.out.println(a.start + "  " + a.end);
        }
//        System.out.println("*******");
//
//        listss.clear();
//        listss.add(new Interval(1, 3));
//        listss.add(new Interval(0, 4));
//        lists = new N56_MergeIntervals().merge(listss);
//        for (Interval a : lists
//                ) {
//            System.out.println(a.start + "  " + a.end);
//        }



    }

    // AC，速度较慢
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
//        for (Interval i : intervals
//             ) {
//            System.out.println(i.start + " " + i.end + " ///");
//        }
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start ||
                    intervals.get(i).start == intervals.get(i + 1).start) {
                merge(i, intervals);
                i--;
            }
        }
        return intervals;
    }

    private void merge(int a, List<Interval> intervals) {
        intervals.set(a, new Interval(intervals.get(a).start,
                Math.max(intervals.get(a).end, intervals.get(a + 1).end)));
        intervals.remove(a + 1);
    }

    // 其他人的解法，速度快
    public List<Interval> merge_(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
