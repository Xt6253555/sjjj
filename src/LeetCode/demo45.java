package LeetCode;
//跳跃游戏||
public class demo45 {
    int a = 0;
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int end = 0;
        int jump =0;
        int fast = 0;
        for (int i = 0; i < nums.length-1; i++) {
            fast=Math.max(fast,i+nums[i]);
            if(end==i){
                jump++;
                end=fast;
            }
        }
        return jump;
    }
}
