package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

//252.会议室
public class demo252 {
    public static void main(String[] args) {
        int arr[][] = {{2,4},{7,10}};
        int arr1[][] = {{0,30},{7,10}};
//        for (int[] ints : arr) {
//            System.out.println(ints[0]);
//        }
//        System.out.println(arr[1][1]);
        System.out.println(canAttendMeetings(arr1));
    }
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a1,a2)->a1[0]-a2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
