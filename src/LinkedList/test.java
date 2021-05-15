package LinkedList;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        //print(0);
        int[] ints1 = twoSum(new int[]{2, 7, 10, 15}, 9);
        for (int a:ints1){
            System.out.println(a);
        }
    }
    public static void print(int n){
        int[] a = new int[4];
        a= new int[]{2, 7, 11, 15};
        int b = 9;
        while (true){
            if(a[n]+a[n+1]!=b){
                print(n+1);
            }else {
                System.out.println(n);
                System.out.println(n + 1);
            }
            break;
        }
    }

    public static  int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
