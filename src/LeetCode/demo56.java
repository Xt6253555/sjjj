package LeetCode;
import java.util.Arrays;

//56.合并区间
public class demo56 {
    public static void main(String[] args) {
        int arr[][] = {{1,3},{2,6},{8,10}};
        merge(arr);
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
