package LeetCode;
//28. 实现 strStr()
public class demo28 {
    public static void main(String[] args) {
        System.out.println(strStr("hello",""));
    }
    public static int strStr(String haystack, String needle) {
        if(needle==null){
            return 0;
        }
        int s = needle.length();
        int e = haystack.length();
        for (int i = 0; i < e - s + 1; i++) {
            if(haystack.substring(i,i+s).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
