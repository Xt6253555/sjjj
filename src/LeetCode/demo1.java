package LeetCode;
import java.util.HashMap;
public class demo1 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                arr[0] = i;
                arr[1] = map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}