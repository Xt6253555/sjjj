package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

//用最少数量的箭引爆气球
public class demo452 {
    public static void main(String[] args) {
         int[][] nums =  {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(findMinArrowShots(nums));
    }
    public static int findMinArrowShots(int[][] points) {
        if(points.length==0)return 0;
        int count = 1;
        //数组按照end升序，points[start][end]
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]<o2[1]?-1:1;
            }
        });
        //最小的end值
        int x = points[0][1];
        //遍历start与end的大小，求出不重叠区间多少个
        for (int point[]:points){
             if(point[0]>x){
                 count++;
                 x=point[1];
             }
        }
        return count;
    }
}
