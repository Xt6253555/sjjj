package Sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {
    public static void main(String[] args) {
        int [] arr = {0,2,5,4,8,9,7};
        //ShellSort(arr);
        ShellSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    //(交换法)
    public static void ShellSort(int[]arr){
        int temp = 0;
        for (int i = arr.length/2; i >0 ; i=i/2) {
            for (int a = i; a < arr.length; a++) {
                //分组进行交换排序
                for (int j = a-i; j >=0 ; j=j-i) {
                    if (arr[j] > arr[j+i]) {
                        temp = arr[j];
                        arr[j]=arr[j+i];
                        arr[j+i]=temp;
                    }
                }
            }
        }
    }
    //(移位法)
    public static void ShellSort1(int[]arr){
        for (int gap = arr.length/2; gap >0 ; gap=gap/2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                //插入排序
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j=j-gap;
                    }
                    //退出while循环
                    arr[j]=temp;
                }
            }
        }
    }
}
