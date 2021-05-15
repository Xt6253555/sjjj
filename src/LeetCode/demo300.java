package LeetCode;

import DesignPattern.strategy.CouponStrategy;

import java.util.Arrays;

//最长递增子序列
public class demo300 {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int [nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
