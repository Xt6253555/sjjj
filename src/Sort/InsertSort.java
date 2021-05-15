package Sort;

import java.util.Arrays;
//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[]arr ={5,4,10,8,-1,90};
        insertSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[]arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;
            while(insertIndex>=0&&insertVal<arr[insertIndex]){//防止数组越界
                arr[insertIndex+1] = arr[insertIndex];//后移位置
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
    }
    public static void insertSort1(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i-1;
            while (index>=0&&val<arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] =val;
        }
    }
}
