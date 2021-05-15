package LeetCode;

import java.util.regex.Pattern;

//正则表达式匹配
//s = "aa"
//p = "a"
//输出: false
public class demo10 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        return Pattern.matches(p,s);
    }
}
