package Search;

import java.util.ArrayList;

//二分查找（数组必须有序）
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2,3,6,6,7,9};
        int i = binarySearch(arr, 0, arr.length-1, 6);
        ArrayList<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 7);
        //System.out.println(i);
        System.out.println(integers);
    }
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        if(left > right){//没有找到
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findVal<midVal){//向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else if(findVal>midVal){//向右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if(left > right){//没有找到
            return new ArrayList<>();
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findVal<midVal){//向左递归
            return binarySearch2(arr,left,mid-1,findVal);
        }else if(findVal>midVal){//向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            //向左遍历
            int temp = mid-1;
            while (true){
                if(temp<0||arr[temp]!=findVal){
                    break;
                }else {
                    list.add(temp);
                    temp--;
                }
            }
            //向右遍历
            int temp1 = mid+1;
            while (true){
                if(temp1>arr.length-1||arr[temp1]!=findVal){
                    break;
                }else {
                    list.add(temp1);
                    temp1++;
                }
            }
            list.add(mid);
            return list;
        }
    }
}
