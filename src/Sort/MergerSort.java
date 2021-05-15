package Sort;

import java.util.Arrays;

//归并排序
public class MergerSort {
    public static void main(String[] args) {
        int[] arr={1,5,4,3,8,9};
        int[]temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //分解办法
    public static void mergeSort(int[]arr,int left,int right,int[]temp){
        if(left<right){
            int mid = (left+right)/2;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //递归完合并
            merge(arr,left,mid,right,temp);
        }
    }
    //合并方法
    public static void merge(int[]arr,int left,int mid,int right,int[]temp){
        int i =left;//左边下标
        int j = mid+1;//右边下标
        int t =0;//新数组第一个为0
        //先合并一个组的元素
        while (i<=mid&&j<=right){
            if (arr[i] <= arr[j]) {
                temp[t]=arr[i];
                t++;
                i++;
            }else{
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        //再合并剩余组的元素，可能是左边或者右边
        while(i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }
        //复制数组
        t=0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
