package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//寻找两个正序数组的中位数
public class demo4 {
    public static void main(String[] args) {
        int arr1[] = {1,2};
        int arr2[] = {3,4};
        double medianSortedArrays = findMedianSortedArrays1(arr1, arr2);
        System.out.println(medianSortedArrays);
    }
    public static double findMedianSortedArrays(int[]A , int[]B ) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j-1] > A[i]){ // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && A[i-1] > B[j]) { // i 需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j-1];
                }
                else if (j == 0) {
                    maxLeft = A[i-1];
                }
                else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }
                if ( (m + n) % 2 == 1 ) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                }
                else if (j == n) {
                    minRight = A[i];
                }
                else {
                    minRight = Math.min(B[j], A[i]); }
                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }
    public static double findMedianSortedArrays1(int[]A , int[]B ){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            list.add(B[i]);
        }
        int[]arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        if(arr.length%2==1){
            return arr[arr.length/2];
        }
        double a = arr[arr.length/2];
        double b = arr[arr.length/2-1];
        return (a+b)/2;
    }
}
