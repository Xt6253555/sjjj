package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//选择排序
public class SelectSort {
    public static void main(String[] args) {
        int []arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        selectSort(arr);
        Date date1 = new Date();
        System.out.println(simpleDateFormat.format(date1));

    }
    public static void selectSort(int[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min=arr[i];//假设第一个为最小值
            for (int j = i+1; j < arr.length; j++) {
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;//找到最小值，并且赋值给索引和数组对应值
                }
            }
            //优化，minIndex=i即不需要交换，直接找到了
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;//交换最小值和对应值的位置
            }
        }
    }
}
