package LeetCode;
//415. 字符串相加
public class demo415 {
    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }
    public static String addStrings(String num1, String num2) {
        int i  =num1.length()-1;
        int j  =num1.length()-1;
        int add = 0;
        StringBuffer sb = new StringBuffer();
        while (i>=0||j>=0||add!=0){
            int x = i>=0?num1.charAt(i)-'0':0;
            int y = j>=0?num2.charAt(j)-'0':0;
            int result = x+y+add;
            sb.append(result%10);
            add = result/10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}
