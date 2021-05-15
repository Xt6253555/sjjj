package LeetCode;

import java.util.Arrays;

//34. 在排序数组中查找元素的第一个和最后一个位置
public class demo34 {
    public static void main(String[] args) {
        int[] arr = {1,4};
        System.out.println(Arrays.toString(searchRange(arr,4)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[]res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums.length==0)return res;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                res[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i]==target){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
