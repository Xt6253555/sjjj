package LeetCode;

import java.util.Arrays;

import static java.util.Arrays.*;

//有效的字母异位词
public class demo242 {
    public static void main(String[] args) {
        System.out.println(isAnagram1("a", "b"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        String s1 = "";
        String t1 = "";
        for (int i = 0; i < chars.length; i++) {
            s1+=chars[i];
        }
        for (int i = 0; i < chart.length; i++) {
            t1+=chart[i];
        }
        if(s1.equals(t1))return true;
        return false;
    }
    public static boolean isAnagram1(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        s = new String(chars);
        t = new String(chart);
        return s.equals(t);
    }
}
