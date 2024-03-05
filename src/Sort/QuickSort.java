package Sort;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int []arr = {46,79,56,38,40,84};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //递归
    public static void QuickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        //pivot中轴值
        int pivot = arr[(left+right)/2];
        int temp=0;
        while(l<r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            temp =arr[l];
            arr[l] =arr[r];
            arr[r] =temp;
            //交换完毕，如果
            if(arr[l]==pivot){
                r--;
            }
            if(arr[r]==pivot){
                l++;
            }
        }
        //如果l==r,需要判断，否则栈溢出
        if(l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r){
            QuickSort(arr,left,r);
        }
        //向右递归
        if (right>l){
            QuickSort(arr,l,right);
        }
    }

    //非递归
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();

            int pivotIndex = partition(arr, start, end);

            if (pivotIndex - 1 > start) {
                stack.push(start);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < end) {
                stack.push(pivotIndex + 1);
                stack.push(end);
            }
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
