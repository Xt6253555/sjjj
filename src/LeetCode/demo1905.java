package LeetCode;
//统计⼦岛屿
public class demo1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length; int n = grid1[0].length;
        //排除grid2的岛在grid1里面是海水
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid1[i][j]==0&&grid2[i][j]==1){
                    dfs(i,j,grid2);
                }
            }
        }

        //统计子岛数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid2[i][j]==1){
                    res++;
                    dfs(i,j,grid2);
                }
            }
        }
        return  res;
    }

    private void dfs(int i, int j, int[][] grid2) {
        int m = grid2.length; int n = grid2[0].length;
        if(i<0||j<0||i>=m||j>=n)return;
        if(grid2[i][j]==0)return;
        grid2[i][j]=0;
        dfs(i-1,j,grid2);
        dfs(i+1,j,grid2);
        dfs(i,j-1,grid2);
        dfs(i,j+1,grid2);
    }
}
