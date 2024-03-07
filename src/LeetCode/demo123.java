package LeetCode;
//买股票的最佳时机III
public class demo123 {
    public int maxProfit(int[] prices) {
        int dp1 = 0;
        int dp2 = 0;
        int min1 = Integer.MIN_VALUE;
        int min2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp1 = Math.max(dp1, prices[i] + min1);
            min1 = Math.max(min1, -prices[i]);
            dp2 = Math.max(dp2, min2 + prices[i]);
            min2 = Math.max(min2, dp1 - prices[i]);
        }
        return dp2;
    }
}
