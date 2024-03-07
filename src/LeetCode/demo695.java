package LeetCode;
//岛屿的最⼤⾯积
public class demo695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    res = Math.max(dfs(i,j,grid),res);
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        if(i<0||j<0||i>=m||j>=n)return 0;
        if(grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+
                dfs(i-1,j,grid)+
                dfs(i+1,j,grid)+
                dfs(i,j-1,grid)+
                dfs(i,j+1,grid);
    }
}
