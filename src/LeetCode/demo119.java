package LeetCode;

import java.util.ArrayList;
import java.util.List;

//119. 杨辉三角 II
public class demo119 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getRow(5));
    }
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex<1){
            list.add(1);
            return list;
        }
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> res = new ArrayList<>(list);
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            for (int j = 0; j < res.size()-1; j++) {
                ans.add(res.get(j)+res.get(j+1));
            }
            ans.add(1);
            list = ans;
        }
        return list;
    }
}
