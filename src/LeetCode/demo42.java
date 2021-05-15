package LeetCode;

import java.math.BigDecimal;

//42. 接雨水
public class demo42 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(arr);
    }
    public static int trap(int[] height) {
        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            left[i] = Math.max(left[i-1],height[i-1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            right[i] = Math.max(right[i+1],height[i+1]);
        }
        for (int i = 1; i < height.length-1; i++) {
            int min = Math.min(left[i],right[i]);
            if(min>height[i]){
                sum+=min-height[i];
            }
        }
        return sum;
    }
}
