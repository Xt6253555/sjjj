package LeetCode;

import java.util.Random;

//随机数索引
public class demo398 {
    int[] nums;
    public demo398(int[] nums) {
        this.nums=nums;
    }

    public int pick(int target) {
        Random random = new Random();
        int res=0;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                k++;
                if(0==random.nextInt(k)){
                    res=i;
                }
            }
        }
        return res;
    }
}
