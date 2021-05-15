package LeetCode;
//按要求补齐数组
public class demo330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0;  // 初始化要补的次数为0次
        long x = 1;  // 初始化x，此时区间为[0,0]
        int length = nums.length;
        int index = 0;   // 从第0个位置开始
        while (x <= n) {  // 退出条件为x大于n，因为x总是代表[1, x-1]被覆盖到
            if (index < length && nums[index] <= x) {
                // 从x=1开始依次判断，每次如果x在数组中，则更新x为x+nums[index]，因为根据贪心思想，我们总保证区间小于x的所有值会被覆盖掉，因此x+1，x+2，... x+nums[index]-1都会被覆盖到，更新x += nums[index]。
                x += nums[index];
                index++;
            } else {
                // x不在数组中，则将x加入，覆盖范围变为2 * x - 1，更新 x *= 2
                x *= 2;
                patches++;
            }
        }
        return patches;
}
}
