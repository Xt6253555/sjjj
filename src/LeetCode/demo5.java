package LeetCode;

import java.util.Arrays;

//最长回文子串
public class demo5 {
    public static void main(String[] args) {
        String ababaabc = longestPalindrome("cabaf");
        System.out.println(ababaabc);
    }
    //中心匹配
    public static String longestPalindrome(String s){
        if(s.length()<2||s==null)return s;
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = longest(s, i, i);
            int r = longest(s, i, i+1);
            len = Math.max(l,r);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public static int longest(String s,int l,int r){
        while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
