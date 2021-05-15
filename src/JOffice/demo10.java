package JOffice;
//矩阵中的路径
public class demo10 {
    public static void main(String[] args) {
        char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, chars, i, j, 0))
                        return true;
                }
            }
        return false;
    }
    static boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length
                || j < 0 || board[i][j] != word[index]){
            return false;
        }
        if (index == word.length - 1){
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        board[i][j] = tmp;
        return res;
    }
}
