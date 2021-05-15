package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//442. 数组中重复的数据
public class demo442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length<2)return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                list.add(nums[i]);
            }
        }
        return list;
    }
}
