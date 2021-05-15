package LeetCode;

import java.util.Arrays;

//136. 只出现一次的数字
public class demo136 {
//    一个数和 0 做 XOR 运算等于本身：a⊕0 = a
//    一个数和其本身做 XOR 运算等于 0：a⊕a = 0
//    XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
//    故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
//    时间复杂度：O(n)O(n)，空间复杂度：O(1)O(1)
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
