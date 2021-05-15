package LeetCode;
//盛最多水的容器
public class demo11 {
    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
        System.out.println(maxArea2(arr));
    }
    public static int maxArea(int[] height){
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                sum = Math.max((j-i)*Math.min(height[i],height[j]),sum);
            }
        }
        return sum;
    }
    public static int maxArea2(int[] height){
        int i = 0;
        int j = height.length-1;
        int sum = 0;
        while (i<j){
            if(height[i]<height[j]){
                sum = Math.max(sum,(j-i)*height[i]);
                i++;
            }else {
                sum = Math.max(sum,(j-i)*height[j]);
                j--;
            }
        }
        return sum;
    }
}
