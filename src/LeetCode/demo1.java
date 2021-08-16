package LeetCode;
import java.util.Arrays;
import java.util.HashMap;
public class demo1 {
    public static void main(String[] args) {
        int num[] = {2,3,4};
        int[] ints = twoSum1(num, 6);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int val = target-num;
            if(map.containsKey(val)){
                res[0] = i;
                res[1] = map.get(val);
                return res;
            }else {
                map.put(num,i);
            }
        }
        return res;
    }
    public static int[] twoSum1(int[] nums, int target){
        int arr[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a  = nums[i];
            int b  = target-nums[i];
            if(map.containsKey(a)){
                arr[0] = i;
                arr[1] = map.get(target-b);
            }
            map.put(b,i);
        }
        return arr;
    }
}