package JOffice;
//青蛙跳台阶问题
public class demo8 {
    public static void main(String[] args) {
        System.out.println(numWays(2));
    }
    public static int numWays(int n) {
        if(n<1){
            return 1;
        }
        int a =0;
        int b =1;
        for (int i = 0; i <= n; i++) {
            int sum  = (a+b)%1000000007;
            a=b;
            b=sum;
        }

        return a;
    }
}
