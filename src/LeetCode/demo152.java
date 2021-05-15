package LeetCode;
//152.乘积最大子数组
public class demo152 {
    public static void main(String[] args) {
        int arr[] =  {3,1,-1,6};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] nums) {
        int sum = Integer.MIN_VALUE,max=1,min=1;
        for(int num:nums){
            if(num<0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num,max*num);
            min = Math.min(num,min*num);
            sum = Math.max(sum,max);
        }
        return  sum;
    }
}
