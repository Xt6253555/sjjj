package LeetCode;

import java.util.*;

//40. 组合总和 II
public class demo40 {
    public static void main(String[] args) {
        int [] arr = {1,1,1,1,3,3,5};
        combinationSum2(arr,8);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, candidates.length, target, path, res);
        return res;
    }
    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i<len;i++){
            if (target-candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates,i+1,len,target-candidates[i],path,res);
            path.removeLast();
        }
    }
}
