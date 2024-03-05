package LeetCode;
//使括号有效的最少添加
public class demo921 {
    public int minAddToMakeValid(String s) {
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if(c=='('){
                l++;
            }else if(c==')'){
                if(l>0){
                    l--;
                }else {
                    r++;
                }
            }
        }
        return l+r;
    }
}
