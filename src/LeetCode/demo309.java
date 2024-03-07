package LeetCode;
//最佳买卖股票时机含冷冻期
public class demo309 {
    public int maxProfit(int[] prices) {
        int dp = 0;
        int pre = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp;
            dp = Math.max(dp,prices[i]+min);
            min =Math.max(min,pre-prices[i]);
            pre = temp;
        }
        return dp;
    }
}
