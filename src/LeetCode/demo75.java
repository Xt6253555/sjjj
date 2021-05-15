package LeetCode;

import java.util.Arrays;

//75.颜色分类
public class demo75 {
    public static void main(String[] args) {
        int [] arr = {2,1,2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortColors(int[] nums) {
        int n1 = 0,n2 = nums.length-1;
        for (int i = 0; i <= n2; i++) {
            while(i<=n2&&nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[n2];
                nums[n2] = temp;
                n2--;
            }
            if(nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[n1];
                nums[n1] = temp;
                n1++;
            }
        }
    }
}
