package Search;

import java.util.Arrays;

//插值查找
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i]=i+1;
        }
        int i = insertValSearch(arr, 0, arr.length - 1, 1);
        System.out.println(i);
    }
    public  static  int insertValSearch(int[]arr,int left,int right,int fandVal){
        System.out.println("次数" +
                "");
        if(left>right||fandVal<arr[0]||fandVal>arr[arr.length-1]){
            return -1;
        }
        int mid = left+(right-left)*(fandVal-arr[left])/(arr[right]-arr[left]);
        int midVal = arr[mid];
        if(fandVal<midVal){//向左递归
            return insertValSearch(arr,left,mid-1,fandVal);
        }else if(fandVal>midVal){//向右递归
            return insertValSearch(arr,mid+1,right,fandVal);
        }else {
            return mid;
        }
    }
}
