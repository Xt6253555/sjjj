package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和

public class demo15 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        for (List<Integer> a:lists) {
            System.out.println(a);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list1 = new ArrayList<>();
        if(nums.length<3){
            return list1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3 ; i++) {
            if(nums[i] > 0){
                break;
            }
            //先对i去重,防止结果重复
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i+1;
            int R = nums.length-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    list1.add(list);
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return list1;
    }
}
