package LeetCode;

//零钱兑换
public class demo322 {
    public static void main(String[] args) {
        int[] coins = {1};
        System.out.println(coinChange(coins,2));
    }
    public static int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        // dp[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        //数组长度设置成amount+1目的是保证所需筹的次数最大
        int[] dp = new int[amount+1];
        //双重for进行穷举
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0 && dp[i-coins[j]] < min){
                    min = dp[i-coins[j]] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
