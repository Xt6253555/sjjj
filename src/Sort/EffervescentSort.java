package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//冒泡排序
public class EffervescentSort {
    public static void main(String[] args) {
//        int[] arr = {5,3,6,9,8};
//        effeSort(arr);
//        System.out.println(Arrays.toString(arr));
        int []arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前"+simpleDateFormat.format(date));
        effeSort(arr);
        Date date1 = new Date();
        System.out.println("排序后"+simpleDateFormat.format(date1));
    }
    public  static void effeSort(int arr[]){
        int temp= 0;
        boolean flag =false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    flag =true;
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag=true;
            }
        }
    }
}
