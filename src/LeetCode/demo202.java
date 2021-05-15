package LeetCode;
//202快乐数
public class demo202 {
    public int sum(int n){
        int sum = 0;
        while (n>0){
            int d = n%10;
            n = n/10;
            sum+=d*d;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = sum(n);
        int fast = sum(sum(n));
        while (slow!=fast){
            slow = sum(slow);
            fast = sum(sum(fast));
        }
        return slow==1;
    }
}
