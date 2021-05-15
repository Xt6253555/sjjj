package LeetCode;

import java.util.HashMap;
//leetcodenb@163.com
//maboshidewovxdnf767
public class demo1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("ab");
        System.out.println(sb.reverse().toString() );
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
        int[]res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target-nums[i];
            if(map.containsKey(val)){
                res[0] = i;
                res[1] = map.get(val);
                return res;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}