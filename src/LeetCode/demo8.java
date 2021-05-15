package LeetCode;
//字符串转换成整数
public class demo8 {
    public static void main(String[] args) {
        System.out.println(myAtoi(" -123word1234"));
    }
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx<n&&chars[idx]==' '){
            idx++;
        }
        if(idx==n){
            return 0;
        }
        boolean navetive = false;
        if(chars[idx]=='-'){
            navetive=true;
            idx++;
        }else if(chars[idx]=='+'){
            idx++;
        }else if(!Character.isDigit(chars[idx])){
            // 非数字符号
            return 0;
        }
        int ans = 0;
        while (idx<n&&Character.isDigit(chars[idx])){
            int dict = chars[idx]-'0';
            if(ans>(Integer.MAX_VALUE-dict)/10){
                return navetive?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans = ans*10+dict;
            idx++;
        }
        return navetive?-ans:ans;
    }
}
