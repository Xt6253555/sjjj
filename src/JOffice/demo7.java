package JOffice;
//斐波那契数列
public class demo7 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    public static int fib(int n) {
        if(n<2&&n>-1){
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int sum = (a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }

}
