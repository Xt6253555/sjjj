package LeetCode;

public class demo1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int []res = new int[1001];
        Difference diff = new Difference(res);
        for (int[] trip : trips) {
            diff.increment(trip[1],trip[2]-1,trip[0]);
        }
        int[] result = diff.result();
        for (int j : result) {
            if (capacity < j) {
                return false;
            }
        }
        return true;
    }
    class Difference{
        private int[] diff;
        public Difference(int[]nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i]-nums[i-1];
            }
        }
        public void increment(int i,int j,int val){
            diff[i]+=val;
            if (j+1<diff.length){
                diff[j+1]-=val;
            }
        }
        public int[] result(){
            int []res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i-1]+diff[i];
            }
            return res;
        }
    }
}
