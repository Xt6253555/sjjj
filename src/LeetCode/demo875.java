package LeetCode;
//爱吃香蕉的珂珂
public class demo875 {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 1000000000;
        int left = 1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(f(piles,mid)==h){
                right = mid-1;
            }else if(f(piles,mid)>h){
                left = mid+1;
            }else if(f(piles,mid)<h){
                right = mid-1;
            }
        }
        return left;
    }
    public static int f(int[] piles, int x){
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours+=piles[i]/x;
            if(piles[i]%x>0){
                hours++;
            }
        }
        return hours;
    }
}
