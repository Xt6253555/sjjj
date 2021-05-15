package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

//无重叠区间
public class demo435 {
    public static void main(String[] args) {
        int [][] nums = {{1,100},{11,22},{1,11},{2,12},};
        System.out.println(eraseOverlapIntervals(nums));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0)return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int x = intervals[0][1];
        int count = 1;
        for (int inter[] : intervals){
            if(inter[0]>=x){
                count++;
                x=inter[1];
            }
        }

        return intervals.length-count;
    }
}
