package LeetCode;
//137. 只出现一次的数字II
public class demo137 {
    public int singleNumber(int[] nums) {
        int one = 0,two = 0;
        for (int num : nums) {
            one = one ^num & ~two;
            two = two ^num & ~one;
        }
        return one;
    }
}
