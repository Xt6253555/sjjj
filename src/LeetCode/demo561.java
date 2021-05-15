package LeetCode;

import java.util.Arrays;

//561. 数组拆分 I
public class demo561 {
    public int arrayPairSum(int[] nums) {
        if(nums.length==0)return 0;
        int sum =0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i+=2) {
            sum+=Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }
}
