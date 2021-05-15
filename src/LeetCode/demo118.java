package LeetCode;

import java.util.ArrayList;
import java.util.List;

//118. 杨辉三角
public class demo118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(1);res.add(ans);
        if(numRows==1) return res;
        for(int i = 2;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 0;j<ans.size()-1;j++){
                list.add(ans.get(j)+ans.get(j+1));
            }
            list.add(1);
            ans = list;
            res.add(ans);
        }
        return res;
    }
}
