package LeetCode;
//最长回文子串
public class demo5 {
    public static void main(String[] args) {
        String ababaabc = longestPalindrome("aba");
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
}
