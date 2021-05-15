package LeetCode;
//只有两个键的键盘
public class demo650 {
    public static void main(String[] args) {
        System.out.println(minSteps(3));
    }
    public static int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
