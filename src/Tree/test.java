package Tree;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        int[]dp = new int[money+1];
        dp[0]=0;
        for (int curMoney = 1; curMoney <= money; curMoney++) {
            for (int j = 1; j <= n; j++) {
                if(curMoney>=p[j-1]){
               dp[curMoney]= Math.max(dp[curMoney],dp[curMoney-p[j-1]]+w[j-1]);
                }
            }
        }
        System.out.println(dp[money]);
    }
}
