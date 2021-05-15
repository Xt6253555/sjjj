package LeetCode;

import java.util.Arrays;

//338.比特位计数
public class demo338 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2));
        //System.out.println(Arrays.toString(countBits(2)));
    }
    public static int[] countBits(int num) {
        int [] res = new int[num+1];
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            String s = Integer.toBinaryString(i);
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='1'){
                    sum++;
                }
            }
            res[i] = sum;
            sum=0;
        }
        return res;
    }
}
