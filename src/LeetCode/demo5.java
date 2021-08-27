package LeetCode;

import java.util.Arrays;

//最长回文子串
public class demo5 {
    public static void main(String[] args) {
        String ababaabc = longestPalindrome1("cabbaf");
        System.out.println(ababaabc);
    }
    //中心匹配
    public static String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int length = s.length();
        int len =1;
        int maxLen = 0;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i-1;
            int r = i+1;
            while (l>=0&&s.charAt(l)==s.charAt(i)){
                len++;
                l--;
            }
            while (r<length&&s.charAt(r)==s.charAt(i)){
                len++;
                r++;
            }
            while (l>=0&&r<length&&s.charAt(l)==s.charAt(r)){
                len=len+2;
                l--;
                r++;
            }
            if(len>maxLen){
                maxLen=len;
                maxStart=l;
            }
            len=1;
        }
        return s.substring(maxStart+1,maxStart+1+maxLen);
    }
    public static String longestPalindrome1(String s){
        if(s==null)return s;
        int start =0;
        int end =0;
        for (int i = 0; i < s.length(); i++) {
            //一个点扩散
            int len1 = expandAroundCenter(s, i, i);
            //两个点扩散
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public static int expandAroundCenter(String s, int left, int right) {
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
