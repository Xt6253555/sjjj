package LeetCode;
//121. 买卖股票的最佳时机
public class demo121 {
    public static void main(String[] args) {
        int arr[] = {7,3,5,1,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length<1)return 0;
        int sum = 0;
        int ans = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]-ans>0){
                sum = Math.max(sum,prices[i]-ans);
            }else{
                ans = prices[i];
            }
        }
        return sum;
    }
}
