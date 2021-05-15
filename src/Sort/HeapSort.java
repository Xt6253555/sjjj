package Sort;

import java.util.Arrays;

//堆排序
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {5,6,4,2,1,8,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int arr[]){
        int temp =0;
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjust(arr,0,j);
        }
    }
    //调整数组为大顶堆
    public static void adjust(int arr[],int i,int length){
        int temp = arr[i];
        for (int k = i*2+1; k < length; k=k*2+1) {
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}
