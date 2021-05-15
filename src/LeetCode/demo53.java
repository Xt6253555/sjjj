package LeetCode;
//53.最大子序和
public class demo53 {
    public static void main(String[] args) {
        int[] arr = {1,2,-4,5,2};
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else{
                sum=num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
