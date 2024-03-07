package LeetCode;

import java.util.Arrays;

//最长公共子序列
public class demo1143 {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        return dp(text1,0,text2,0);
    }

    private int dp(String text1, int i, String text2, int j) {
        if(i==text1.length()||j==text2.length())return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            memo[i][j] = 1+dp(text1,i+1,text2,j+1);
        }else{
            memo[i][j] = Math.max(dp(text1,i+1,text2,j),dp(text1,i,text2,j+1));
        }
        return memo[i][j];
    }
}
