package LeetCode;

import java.util.Arrays;

//两个字符串的删除操作
public class demo583 {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        int dp = dp(word1, 0, word2, 0);
        return m-dp+n-dp;
    }

    private int dp(String s1, int i, String s2, int j) {
        if(i==s1.length()||j==s2.length())return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j] = 1+dp(s1,i+1,s2,j+1);
        }else{
            memo[i][j] = Math.max(dp(s1,i+1,s2,j),dp(s1,i,s2,j+1));
        }
        return memo[i][j];
    }
}
