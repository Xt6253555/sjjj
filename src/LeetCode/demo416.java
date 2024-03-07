package LeetCode;
//分割等和子集
public class demo416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum+=num;
        if(sum%2==1)return false;
        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if(j-nums[i]>=0){
                    dp[j] = dp[j]||dp[j-nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
