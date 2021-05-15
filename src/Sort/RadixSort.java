package Sort;

import java.util.Arrays;
//基数（桶）排序
public class RadixSort {
    public static void main(String[] args) {
        int arr[] ={15,1,5,2,3,4,20,11,23,56,7,8,9,0};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    //基数排序方法
    public static void radixSort(int[]arr){
        //获取数组最大数字的长度
        int max= arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        int maxLength = (max+"").length();

        int[][] bucket = new int[10][arr.length];
        //记录桶中有多少个数字，方便取出覆盖
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n=1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            //遍历桶中数据，放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }
}
