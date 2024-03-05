package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

//优势洗牌
public class demo870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (int[] pair1,int[] pair2)->{
                    return pair2[1]-pair1[1];
                }
        );
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i,nums2[i]});
        }
        Arrays.sort(nums1);
        int[] res = new int[n];
        int l =0;
        int r =n-1;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int i = poll[0];
            int maxVal = poll[1];
            if(nums1[r]>maxVal){
                res[i]=nums1[r];
                r--;
            }else{
                res[i]=nums1[l];
                l++;
            }
        }
        return res;
    }
}
