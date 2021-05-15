package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//90. 子集 II
public class demo90 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {4,4,4,1,4};
        System.out.println(subsetsWithDup(arr));
        System.out.println(subsetsWithDup(arr).size());
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(0,nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (List<Integer> a : res) {
            Collections.sort(a);
            if(!ans.contains(a)){
                ans.add(a);
            }
        }
        return ans;
    }
    public static void dfs(int cur,int[] nums){
        res.add(new ArrayList<>(list));
        for(int i = cur;i<nums.length;i++){
            list.add(nums[i]);
            dfs(i+1,nums);
            list.remove(list.size()-1);
        }
    }
}
