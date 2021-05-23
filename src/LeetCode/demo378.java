package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//378. 有序矩阵中第 K 小的元素
public class demo378 {
    public static void main(String[] args) {

    }
    public int kthSmallest(int[][] matrix, int k) {
        int arr[] = new int[matrix.length*matrix.length];
        int i =0;
        for (int[] ints : matrix) {
            for (int a : ints) {
                arr[i++] = a;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}
