package Search;

//线性查找
public class SearchLinear {
    public static void main(String[] args) {
        int[] arr= {1,3,4,5};
        int linear = linear(arr, 1);
        if (linear ==-1){
            System.out.println("没有找到");
        }else {
            System.out.println(linear);
        }
    }
    public static int linear(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(value==arr[i]){
                return i;
            }
        }
        return -1;
    }
}
