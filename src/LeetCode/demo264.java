package LeetCode;
//264.丑数II
public class demo264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) {
        int[] num = new int[n];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        num[0] = 1;
        int temp = 1;
        for(int i = 1;i<n;i++){
            temp = Math.min(Math.min(num[i2]*2,num[i3]*3),num[i5]*5);
            num[i] = temp;
            if(temp==num[i2]*2){
                i2++;
            }
            if(temp==num[i3]*3){
                i3++;
            }
            if(temp==num[i5]*5){
                i5++;
            }
        }
        return num[n-1];
    }
}
