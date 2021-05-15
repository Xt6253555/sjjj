package LeetCode;

import java.util.Arrays;

//215. 数组中的第K个最大元素
public class demo215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int i = nums.length-1;
        int sum = 0;
        while(k>0){
            sum = nums[i];
            i--;
            k--;
        }
        return sum;
    }
}
