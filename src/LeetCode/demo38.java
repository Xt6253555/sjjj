package LeetCode;
//外观数列
public class demo38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if(n==1)return "1";
        String s = countAndSay(n-1);
        StringBuilder res = new StringBuilder();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(start)){
                res.append(i-start).append(s.charAt(start));
                start=i;
            }
        }
        res.append(s.length()-start).append(s.charAt(start));
        return res.toString();
    }
}
