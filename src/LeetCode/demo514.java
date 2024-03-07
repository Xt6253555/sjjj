package LeetCode;
//自由之路
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//自由之路
public class demo514 {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                char c = key.charAt(i);
                for (int k : map.get(c)) {
                    int diff = Math.abs(j - k);
                    int steps = Math.min(diff, n - diff);
                    dp[i][j] = Math.min(dp[i][j], steps + dp[i + 1][k]);
                }
            }
        }

        return dp[0][0] + m;
    }
}
