package LeetCode;

import java.util.Arrays;

//57. 插入区间
public class demo57 {
    public static void main(String[] args) {
        int arr[][] = {{1,2},{3,4}};
        int res[] = {5,6};
        int[][] ints = insert(arr, res);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int res[][] = new int[intervals.length+1][2];
        int index = 0;
        for (int[] interval : intervals) {
            res[index] = interval;
            index++;
        }
        res[index] = newInterval;
        int[][] merge = merge(res);
        return merge;
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a1,a2)->a1[0]-a2[0]);
        int res[][] = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if(index==-1||interval[0]>res[index][1]){
                res[++index] = interval;
            }else{
                res[index][1] = Math.max(interval[1],res[index][1]);
            }
        }
        return Arrays.copyOf(res,index+1);
    }
}
