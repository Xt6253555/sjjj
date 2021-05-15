package LeetCode;

import java.util.Arrays;

//238. 除自身以外数组的乘积
public class demo238 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int l = 1, r = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = l;
            l *= nums[i];
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            r *= nums[i];
            res[i - 1] *= r;
        }
        return res;
    }
}
