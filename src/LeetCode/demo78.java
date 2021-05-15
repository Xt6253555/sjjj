package LeetCode;

import java.util.ArrayList;
import java.util.List;

//78. 子集
public class demo78 {
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        System.out.println(subsets(arr));
    }
    static List<Integer> list = new ArrayList<Integer>();
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }
    public static void dfs(int cur, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = cur; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
