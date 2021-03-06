package LeetCode;

import java.util.Arrays;

//62. 不同路径
public class demo62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
    public static int uniquePaths(int m, int n) {
        int cur[] = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j]+=cur[j-1];
            }
        }
        return cur[n-1];
    }
}
