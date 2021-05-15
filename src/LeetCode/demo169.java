package LeetCode;

import java.util.HashMap;

//169.多数元素
public class demo169 {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length/2;
        int count = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],count);
            }
        }
        for(Integer a:map.keySet()){
            if(map.get(a)>n){
                return a;
            }
        }
        return 0;
    }

}
