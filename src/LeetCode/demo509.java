package LeetCode;
//斐波那契数
public class demo509 {
    public static void main(String[] args) {
        System.out.println(fib(30));
    }
    public static int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        return fib(n-1)+ fib(n-2);
    }
}
