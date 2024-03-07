package LeetCode;
//解数独
public class demo37 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后⼀列的话就换到下⼀⾏重新开始。
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // 找到⼀个可⾏解，触发 base case
            return true;
        }
        if (board[i][j] != '.') {
            // 如果有预设数字，不⽤我们穷举
            return backtrack(board, i, j + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch)) continue;
            board[i][j] = ch;
            // 如果找到⼀个可⾏解，⽴即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // 穷举完 1~9，依然没有找到可⾏解，此路不通
        return false;
    }

    // 判断 board[i][j] 是否可以填⼊ n
    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断⾏是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 ⽅框是否存在重复
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) return false;
        }
        return true;
    }
}
