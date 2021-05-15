package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

//179最大数
public class demo179 {
    public static void main(String[] args) {
        int arr[] = {3,30,34,5,9};
        System.out.println(largestNumber(arr));
    }
    private static class LargerNumberComparator implements Comparator<String> {
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new LargerNumberComparator());
        if (arr[0].equals("0")) {
            return "0";
        }
        String s = new String();
        for (String str : arr) {
            s += str;
        }
        return s;
    }
}
