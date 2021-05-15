package LeetCode;

import java.util.Arrays;

//88. 合并两个有序数组
public class demo88 {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {4,5,6};
        merge(nums1,3,nums2,2);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m -1;
        int l2 = n -1;
        int l = m+n -1;
        while (l1>=0&&l2>=0){
            nums1[l--] = nums1[l1]>nums2[l2]?nums1[l1--]:nums2[l2--];
        }
        for(int i=0;i<l2+1;i++){
            nums1[i]=nums2[i];
        }
    }
}
