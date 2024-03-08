package LeetCode;
//错误的集合
public class demo645 {
    public int[] findErrorNums(int[] nums) {
        int[]arr = new int[2];
        int n = nums.length;
        int[]res = new int[n+1];
        for (int num : nums) res[num]++;
        for (int i = 1; i <= n; i++) {
            if(res[i]==0)arr[1]=i;
            if(res[i]==2)arr[0]=i;
        }
        return arr;
    }
}
