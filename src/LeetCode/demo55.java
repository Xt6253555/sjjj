package LeetCode;
//跳跃游戏|
public class demo55 {
    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums) {
        int length = 0;
        for(int i = 0; i < nums.length; i++){
            if(length<i)return false;
            length = Math.max(length,i+nums[i]);
        }
        return true;
    }
}
