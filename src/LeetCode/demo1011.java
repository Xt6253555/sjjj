package LeetCode;
//在 D 天内送达包裹的能力
public class demo1011 {
    public int shipWithinDays(int[] weights, int days){
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            if(left<weights[i]){
                left = weights[i];
            }
            right+=weights[i];
        }
        while (left<=right){
            int mid = left+(right-left)/2;
            if(f(weights,mid)==days){
                right = mid-1;
            }else if(f(weights,mid)>days){
                left = mid+1;
            }else if(f(weights,mid)<days){
                right = mid-1;
            }
        }
        return left;
    }
    public static int f(int[] weight,int x){
        int day = 0;
        int sum = 0;
        for (int i = 0; i < weight.length; i++) {
            sum+=weight[i];
            if(sum>x){
                day++;
                sum = 0;
                i = i-1;
            }
            if(i==weight.length-1){
                day++;
            }
        }
        return day;
    }
}
