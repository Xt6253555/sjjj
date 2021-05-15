package LeetCode;

import java.util.ArrayList;
import java.util.List;

//22. 括号生成
public class demo22 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String s:list) {
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }
        dfs("", 0, 0, n, res);
        return res;
    }
    private static void dfs(String curStr, int left, int right, int n, List<String> res) {
        if(left==n&&right==n){
            res.add(curStr);
            return;
        }
        if(left<right){
            return;
        }
        if(left<n){
            dfs(curStr+"(",left+1,right,n,res);
        }
        if(right<n){
            dfs(curStr+")",left,right+1,n,res);
        }
    }
}
