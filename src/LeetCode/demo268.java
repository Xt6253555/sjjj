package LeetCode;

import java.util.Arrays;
import java.util.SortedMap;

//268.丢失的数字
public class demo268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]-nums[i]>1){
                return nums[i]+1;
            }
        }
        return nums[nums.length]+1;
    }
}
