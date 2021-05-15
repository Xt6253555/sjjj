package LeetCode;
//91.解码方法
public class demo91 {
    public static void main(String[] args) {
        numDecodings("120");
    }
    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') return 0;
        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0'){
                dp[i + 1] = dp[i];
            }
            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }
}
