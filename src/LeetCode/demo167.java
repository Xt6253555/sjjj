package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

//167. 两数之和 II - 输入有序数组
public class demo167 {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length<2)return numbers;
        int[]res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])){
                res[0] = map.get(target-numbers[i])+1;
                res[1] = i+1;
                return res;
            }else{
                map.put(numbers[i],i);
            }
        }
        return res;
    }
    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}
