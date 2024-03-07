package LeetCode;
//统计封闭岛屿的数⽬
public class demo1254 {
    public int closedIsland(int[][] grid) {
        //淹没上下左右岛屿，中间就是封闭岛屿
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            //淹没上下岛屿
            dfs(i,0,grid);
            dfs(i,n-1,grid);
        }
        for (int j = 0; j < n; j++) {
            //淹没左右岛屿
            dfs(0,j,grid);
            dfs(m-1,j,grid);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(i<0||j<0||i>=m||j>=n)return;
        if(grid[i][j]==1)return;
        grid[i][j]=1;
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}
