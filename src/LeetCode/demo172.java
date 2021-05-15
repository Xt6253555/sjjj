package LeetCode;
//172.阶乘后的零
public class demo172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n>0){
            n/=5;
            count+=n;
        }
        return count;
    }
}
