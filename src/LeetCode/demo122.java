package LeetCode;
//122. 买卖股票的最佳时机 II
public class demo122 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length<1)return 0;
        int count = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i+1]-prices[i]>0){
                count+=(prices[i+1]-prices[i]);
            }
        }
        return count;
    }
}
