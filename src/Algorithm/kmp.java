package Algorithm;

import java.util.Arrays;

//kmp算法解决字符串子串匹配
public class kmp {
    public static void main(String[] args) {
        String s1 = "123acaba345";
        String s2 = "aba";
        //System.out.println(violenceMatch(s1, s2));
        //System.out.println(Arrays.toString(kmpNext("ABCDABD")));
        System.out.println(kmp(s1,s2,kmpNext("aba")));
    }

    //暴力匹配算法实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = 0;//指向s1
        int j = 0;//指向s2
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2.length) {
            return i - j;
        } else {
            return -1;
        }
    }
    //kmp算法实现
    public static int kmp(String str1,String str2,int next[]){
        for (int i = 0,j=0; i < str1.length(); i++) {
            while (j>0&&str1.charAt(i) != str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i-j+1;
            }
        }
        return -1;
    }
    //kmp算法实现前提（获取字符串的部分匹配值）
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;//字符串长度为0.即匹配值为0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
