package LeetCode;
//162.寻找峰值
public class demo162 {
    public int findPeakElement(int[] nums) {
        int min = Integer.MIN_VALUE;
        if(nums.length==1)return 0;
        if(nums[0]>min&&nums[0]>nums[1]){
            return 0;
        }
        for(int i = 1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                return i;
            }
        }
        if(nums[nums.length-1]>min&&nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        return -1;
    }
}
