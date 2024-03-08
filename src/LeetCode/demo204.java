package LeetCode;

import java.util.Arrays;

//计数质数
public class demo204 {
    public int countPrimes(int n) {
        Boolean[] isPrimes = new Boolean[n];
        Arrays.fill(isPrimes,true);
        for (int i = 2; i*i < n; i++) {
            if(isPrimes[i]){
                for (int j = i*i; j < n; j+=i) {
                    isPrimes[j]=false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrimes[i])count++;
        }
        return count;
    }
}
