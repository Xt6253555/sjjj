package LeetCode;
//买股票的最佳时机IV
public class demo188 {
    public int maxProfit(int k, int[] prices) {
        if(k==0||prices.length<=1)return 0;
        int[][] dp= new int[2][k+1];
        for (int j = 1; j <= k; j++) {
            dp[1][j] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[0][j]= Math.max(dp[0][j],dp[1][j]+prices[i]);
                dp[1][j] = Math.max(dp[1][j],dp[0][j-1]-prices[i]);
            }
        }
        return dp[0][k];
    }
}
