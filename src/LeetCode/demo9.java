package LeetCode;
//回文数
public class demo9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-10));
    }
    public static boolean isPalindrome(int x){
        if(x<0)return false;
        String s = String.valueOf(x);
        int i =0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
