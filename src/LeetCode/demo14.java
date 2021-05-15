package LeetCode;
//最长公共前缀
public class demo14 {
    public static void main(String[] args) {
        String arr[]={"baab","bacb","b","cbd"};
        //System.out.println(longest("b","cbc"));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String  ans = "";
        ans = strs[0];
        for (int i = 0; i < strs.length-1; i++) {
            ans = commonString(ans,strs[i+1]);
        }
        return ans;
    }
    public static  String commonString(String a,String b){
        int length = 0;
        String s= "";
        if(a.length()>b.length()){
            length = b.length();
        }else{
            length = a.length();
        }
        for (int i = 0; i < length; i++) {
            if(a.charAt(i)==b.charAt(i)){
                s= s+a.charAt(i);
            }else if(a.charAt(0)!=b.charAt(0)){
                return "";
            }else if(a.charAt(i)!=b.charAt(i)){
                return s;
            }
        }
        return s;
    }
}
