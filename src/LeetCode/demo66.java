package LeetCode;
//66. 加一
public class demo66 {
    public static void main(String[] args) {
        int arr [] = {1,2,9};
        plusOne(arr);
    }
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i]!=0)return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
