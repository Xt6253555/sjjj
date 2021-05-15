package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

//27. 移除元素
public class demo27 {
    public static void main(String[] args) {
        int arr[] = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
    }
    public static int removeElement(int[] nums, int val) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
           if (nums[i]!=val){
               list.add(nums[i]);
           }
        }
        int i = 0;
        for (int a:list) {
            nums[i]= a;
            i++;
        }
        System.out.println(Arrays.toString(nums));
        return list.size();
    }
}
