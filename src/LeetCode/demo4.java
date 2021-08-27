package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//寻找两个正序数组的中位数
public class demo4 {
    public static void main(String[] args) {
        int arr1[] = {};
        int arr2[] = {2,3};
        double medianSortedArrays = findMedianSortedArrays(arr1, arr2);
        System.out.println(medianSortedArrays);
    }
    //逆双指针
    public static double findMedianSortedArrays(int[]nums1 , int[]nums2 ) {
        int[] C = Arrays.copyOf(nums1,nums1.length+nums2.length);
        int c = C.length-1;
        int a = nums1.length-1;
        int b = nums2.length-1;
        while (a>=0&&b>=0){
            C[c--] = nums1[a]>nums2[b]?nums1[a--]:nums2[b--];
        }
        while (b>=0){
            C[c--] = nums2[b--];
        }
        if(C.length%2==1){
            return C[C.length/2];
        }
        return (C[C.length/2]+C[C.length/2-1])/2.0d;
    }
}
