package JOffice;
//旋转数组的最小数字
public class demo9 {
    public static void main(String[] args) {
        int muns[] = {2,2,2,0,1};
        System.out.println(minArray(muns));
    }
    public static int minArray(int[] numbers) {
        if(numbers.length<1){
            return 0;
        }
        int min=numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        return min;
    }
}
