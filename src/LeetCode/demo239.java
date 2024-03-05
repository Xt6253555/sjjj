package LeetCode;

import java.util.ArrayDeque;

//滑动窗口最大值
public class demo239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2)return nums;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int l=0,r =0;
        int[] res = new int[nums.length-k+1];
        while (r<nums.length){
            while (!stack.isEmpty()&&nums[stack.peekLast()]<nums[r]){
                stack.pollLast();
            }
            stack.addLast(r);
            if(stack.peekFirst()<=r-k){
                stack.pollFirst();
            }
            if(r-l==k-1){
                res[l] = nums[stack.peekFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
