package LeetCode;

import java.util.ArrayList;
import java.util.List;

//46.全排列
public class demo46 {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        permute(arr);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<1)return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, nums.length, list, used, res);
        return res;
    }

    private static void dfs(int[] nums, int depth, int len, List<Integer> list, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                dfs(nums, depth+1, len, list, used, res);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
