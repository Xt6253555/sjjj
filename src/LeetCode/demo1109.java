package LeetCode;
//航班统计
public class demo1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int []res = new int[n];
        Difference difference = new Difference(res);
        for (int[] booking : bookings) {
            difference.increment(booking[0]-1,booking[1]-1,booking[2]);
        }
        return difference.result();
    }
    class Difference{
        private int[]diff;
        public Difference(int[]nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i]-nums[i-1];
            }
        }
        public void increment(int i,int j,int val){
            diff[i]+=val;
            if(j+1<diff.length){
                diff[j+1]-=val;
            }
        }
        public int[] result(){
            int[]res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i-1]+diff[i];
            }
            return res;
        }
    }
}
