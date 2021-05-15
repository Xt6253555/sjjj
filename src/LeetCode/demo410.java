package LeetCode;
//410. 分割数组的最大值
public class demo410 {
    public int splitArray(int[] nums, int m) {
        int left = 0,right = 0;
        for (int i = 0; i < nums.length; i++) {
            right+=nums[i];
            if(left<nums[i]){
                left = nums[i];
            }
        }
        while (left<right){
            int mid=(left+right)/2;
            if(check(nums,mid,m)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if(sum+nums[i]>x){
                ans++;
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
        }
        return  ans<=m;
    }
}
