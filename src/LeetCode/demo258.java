package LeetCode;
//258各位相加
public class demo258 {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
    public static int addDigits(int num) {
        if(num<10)return num;
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum+=chars[i]-'0';
        }
        return addDigits(sum);
    }
}
