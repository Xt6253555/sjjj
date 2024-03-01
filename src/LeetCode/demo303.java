package LeetCode;

//区域和检索
public class demo303 {
    private int[] preNums;

    public demo303(int[] nums) {
        preNums = new int[nums.length + 1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preNums[right + 1] - preNums[left];
    }
}
