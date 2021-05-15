package LeetCode;

public class demo50 {
    public static void main(String[] args) {
        System.out.println(myPow(2d,4));
    }
    public static double myPow(double x, int n) {
        if(x==0.0f)return 0.0d;
        long b = n;
        double res = 1.0;
        if(b<0){
            x = 1/x;
            b = -b;
        }
        while(b>0){
            if(b%2==1)res *=x;
            x *=x;
            b=b/2;
        }
        return res;
    }
}
