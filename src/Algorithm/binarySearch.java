package Algorithm;
//二分查找（非递归）
public class binarySearch {
    public static void main(String[] args) {
        int arr[]={1,3,5,7,8};
        int i = binarySearch(arr, 7);
        System.out.println(i+1
        );
    }
    public static int binarySearch(int arr[],int target){
        int left = 0;
        int right =arr.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
}
