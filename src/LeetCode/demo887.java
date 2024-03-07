package LeetCode;
//鸡蛋掉落
public class demo887 {
    public int superEggDrop(int K, int N) {
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m]<N){
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m]=dp[k][m-1]+dp[k-1][m-1]+1;
            }
        }
        return m;
    }
}
