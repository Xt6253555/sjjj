package LeetCode;
//171Excel表列序号
public class demo171 {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int sum = s.charAt(i)-'A'+1;
            ans = ans*26+sum;
        }
        return ans;
    }
}
