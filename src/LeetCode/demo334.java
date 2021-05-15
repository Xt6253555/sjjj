package LeetCode;
//334. 递增的三元子序列
public class demo334 {
    public static void main(String[] args) {
       int arr[] = {2,4,-2,-3};
        System.out.println(increasingTriplet(arr));
    }
    public static boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for(int three : nums){
            if(three > two){
                return true;
            }else if(three <= one){
                one = three;
            }else{
                two = three;
            }
        }
        return false;
    }
}
