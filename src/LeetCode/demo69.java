package LeetCode;

import java.text.DecimalFormat;

public class demo69 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(sqrt(8)));
        System.out.println(sqrt(9));
    }
    public static double sqrt(int n){
           return Math.sqrt(n);
    }
    public static int mySqrt(int x) {
        int l = 0,r=x,res = -1;
        while (l<=r){
            int mid = (l+r)/2;
            if((long)mid*mid<=x){
                res = mid;
                l = mid+1;
            }else {
                r = mid -1;
            }
        }
        return res;
    }
}
