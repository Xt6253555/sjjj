package LeetCode;
//29. 两数相除
public class demo29 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,2));
    }
    public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        int result=0;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor) {
            dividend-=divisor;
            result+=1;
        }
        return k?result:-result;
    }
}
