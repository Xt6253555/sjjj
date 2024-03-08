package LeetCode;

import java.util.Arrays;

//删除被覆盖区间
public class demo1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b)-> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = intervals.length;
        int pre = 0;
        for (int[] interval : intervals) {
            if(pre>=interval[1])n--;
            pre=Math.max(pre,interval[1]);
        }
        return n;
    }
}
