package LeetCode;

import java.util.ArrayList;
import java.util.List;

//54. 螺旋矩阵
public class demo54 {
    public static void main(String[] args){
        int [][] arr = {{1},{2}};
        System.out.println(spiralOrder(arr));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)return list;
        int row = matrix.length,col = matrix[0].length;
        int l=0,r=col-1,t=0,b=row-1;
        while (l<=r&&t<=b){
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            for (int i = t+1; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            if(l<r&&t<b){
                for (int i = r-1; i > l; i--) {
                    list.add(matrix[b][i]);
                }
                for (int i = b; i > t; i--) {
                    list.add(matrix[i][l]);
                }
            }
            l++;
            t++;
            r--;
            b--;
        }
        return list;
    }

}
