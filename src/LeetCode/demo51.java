package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo51 {
    List<String> list = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        bucks(board,0);
        return res;
    }
    public void bucks(char[][] board, int row){
        if(board.length==row)res.add(new ArrayList<>(list));
        for (int i = 0; i < board.length; i++) {
            if(!isVaild(board,row,i))continue;
            board[row][i] = 'Q';
            list.add(new String(board[row]));
            bucks(board,row+1);
            board[row][i] = '.';
            list.remove(list.size()-1);
        }
    }

    private boolean isVaild(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if(board[i][col]=='Q')return false;
        }
        for(int i = row-1,j = col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }
        for(int i = row-1,j = col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
}
