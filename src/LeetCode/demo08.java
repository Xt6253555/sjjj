package LeetCode;

import sun.misc.PostVMInitHook;

//硬币
public class demo08 {
    public static void main(String[] args) {
        System.out.println(waysToChange(10));
    }
    public static int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int coin:coins){
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i]+dp[i-coin])%1000000007;
            }
        }
        return dp[n];
    }
}
