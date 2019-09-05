package cn.geliang.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode435 {
     // 20190726
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalList);
        int preIdx = 0;
        int idx = 1;
        int ans = 1;
        for (; idx < intervals.length; idx++) {
            if (intervalList.get(idx).start >= intervalList.get(preIdx).end) {
                preIdx = idx;
                ans++;
            }
        }
        return idx - ans;
    }

    private class Interval implements Comparable<Interval>{
        private int start;
        private int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            if (start != o.start) {
                return end - o.end;
            }
            return start = o.start;
        }

    }

    public static void main(String[] args) {
        Leetcode435 sol = new Leetcode435();
        int[][] intervals = {{1,3},{2,3},{3,4},{1,2}};
        System.out.println(sol.eraseOverlapIntervals(intervals));
    }
}
