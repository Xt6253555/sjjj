package LeetCode;
//213. 打家劫舍 II
public class demo213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int dp[] = new int[nums.length-1];
        int arr[] = new int[nums.length-1];
        for (int i = 0; i < nums.length - 1; i++) {
            dp[i] = nums[i];
        }
        for (int i = 0; i < nums.length-1; i++) {
            arr[i] = nums[i+1];
        }
        return Math.max(srob(arr),srob(dp));
    }
    public static int srob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
