package LeetCode;

import java.util.Arrays;

//16. 最接近的三数之和
public class demo16 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,-3};
        System.out.println(threeSumClosest(arr, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int end = nums[l]+nums[r]+nums[i];
                if(Math.abs(end-target)<Math.abs(start-target)){
                    start=end;
                }else if(end>target){
                    r--;
                }else if(end<target){
                    l++;
                }else{
                    return target;
                }
            }
        }
        return start;
    }
}
