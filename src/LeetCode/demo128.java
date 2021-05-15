package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//128. 最长连续序列
public class demo128 {
    public static void main(String[] args) {
        int arr[] = {0,1,1,2};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(!list.contains(nums[j])){
                list.add(nums[j]);
            }
        }
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        if(arr.length<2)return arr.length;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]+1==arr[i+1]){
                ans++;
            }else{
                ans=0;
            }
            sum = Math.max(sum,ans+1);
        }
        return sum;
    }

}
