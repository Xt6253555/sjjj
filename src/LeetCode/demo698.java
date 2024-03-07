package LeetCode;

import java.util.HashMap;

//划分为k个相等的子集
public class demo698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除⼀些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        int used = 0; // 使⽤位图技巧
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }
    HashMap<Integer, Boolean> memo = new HashMap<>();
    boolean backtrack(int k, int bucket,
                      int[] nums, int start, int used, int target) {
        // base case
        if (k == 0) {
            // 所有桶都被装满了，⽽且 nums ⼀定全部⽤完了
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下⼀个桶的选择
            // 让下⼀个桶从 nums[0] 开始选数字
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            // 缓存结果
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                // nums[i] 已经被装⼊别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择
            used |= 1 << i; // 将第 i 位置为 1
            bucket += nums[i];
            // 递归穷举下⼀个数字是否装⼊当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used ^= 1 << i; // 将第 i 位置为 0
            bucket -= nums[i];
        }
        return false;
    }
}
