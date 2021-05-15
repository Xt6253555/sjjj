package LeetCode;
//59. 螺旋矩阵 II
public class demo59 {
    public int[][] generateMatrix(int n) {
        int sum = 1;
        int[][] arr = new int[n][n];
        if(n<1)return arr;
        int row = arr.length,col = arr[0].length;
        int l=0,r=col-1,t=0,b=row-1;
        while (l<=r&&t<=b){
            for (int i = l; i <= r; i++) {
                arr[t][i] = sum;
                sum++;
            }
            for (int i = t+1; i <= b; i++) {
                arr[i][r] = sum;
                sum++;
            }
            if(l<r&&t<b){
                for (int i = r-1; i > l; i--) {
                    arr[b][i] = sum;
                    sum++;
                }
                for (int i = b; i > t; i--) {
                    arr[i][l] = sum;
                    sum++;
                }
            }
            l++;
            t++;
            r--;
            b--;
        }
        return arr;
    }
}
