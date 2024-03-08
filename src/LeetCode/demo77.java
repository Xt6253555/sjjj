package LeetCode;

import java.util.ArrayList;
import java.util.List;

//组合
public class demo77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) return res;
        backtrack(n, k, 1, list);
        return res;
    }
    public void backtrack(int n, int k, int start, List<Integer> list){
        if(list.size()==k) res.add(new ArrayList<>(list));
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(n,k,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
