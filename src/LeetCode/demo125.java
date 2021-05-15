package LeetCode;
//125. 验证回文串
public class demo125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isLetterOrDigit(chars[i])){
                sb.append(Character.toLowerCase(chars[i]));
            }
        }
        StringBuffer bu = new StringBuffer(sb).reverse();
        return bu.toString().equals(sb.toString());
    }
}
