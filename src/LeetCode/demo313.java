package LeetCode;
//313.超级丑数
public class demo313 {
    public static void main(String[] args) {
        int arr[] = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(12,arr));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int k = primes.length;
        int[] index = new int[k];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min,dp[index[j]] * primes[j]);
                dp[i] = min;
            }
            for (int j = 0; j < k; j++) {
                if (min == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
