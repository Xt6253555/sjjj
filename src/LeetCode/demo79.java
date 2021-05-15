package LeetCode;
//79.单词搜索
public class demo79 {
    public static void main(String[] args) {
        char arr[][] = {{'a','b','c'},{'d','e','f'}};
        exist(arr,"abc");
    }
    public static boolean exist(char[][] board, String word) {
        int h = board.length; int w = board[0].length;
        boolean visit[][] = new boolean[h][w];
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                boolean flag = dfs(board,visit,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(char[][] board, boolean[][] visit, int i, int j, String s, int k) {
        if(board[i][j]!=s.charAt(k)){
            return false;
        }else if(k==s.length()-1){
            return true;
        }
        visit[i][j] =true;
        int[][] dist = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean res = false;
        for(int[] dis : dist){
            int newi = i+dis[0];int newj = j+dis[1];
            if(newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                if(!visit[newi][newj]){
                    boolean flag = dfs(board,visit,newi,newj,s,k+1);
                    if(flag){
                        res = true;
                        break;
                    }
                }
            }
        }
        visit[i][j] = false;
        return res;
    }
}
