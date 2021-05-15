package LeetCode;
//96.不同的二叉搜索树
public class demo96 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    public static int numTrees(int n) {
        int[]G = new int[n+1];
        G[0] =1;
        G[1] =1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i+1; j++) {
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
