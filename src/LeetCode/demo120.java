package LeetCode;

import java.util.ArrayList;
import java.util.List;

//120. 三角形最小路径和
public class demo120 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(-7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(-1);
        list2.add(2);
        list2.add(2);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list);
        res.add(list1);
        res.add(list2);
        System.out.println(minimumTotal(res));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <=i; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
