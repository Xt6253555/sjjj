package LeetCode;

import java.util.Arrays;

//31. 下一个排列
public class demo31 {
    public static void main(String[] args) {
        int[] a={2,5,4,3,2,1};
        Arrays.sort(a,2,5);
        System.out.println(Arrays.toString(a));
    }
    public static void nextPermutation(int[] nums) {
        if(nums==null||nums.length<2){
            return;
        }
        int first =-1,second = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                first = i;
                break;
            }
        }
        if(first==-1){
            Arrays.sort(nums);
            return;
        }
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]>nums[first]){
                second = i;
                break;
            }
        }
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
        Arrays.sort(nums,first+1,nums.length);
    }

}
