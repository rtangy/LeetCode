/**
 * leetcode130
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 2021年 7 月 6 日
 */
public class Solution1 {
    private int m,n;
    private int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ;
        }
        m = board.length;
        n = board[0].length;

        for (int i = 0;i < m;i++) {
            dfs(board,i,0);
            dfs(board,i,n - 1);
        }

        for (int i = 1;i < n - 1;i++) {
            dfs(board,0,i);
            dfs(board,m - 1,i);
        }

        // 遍历替换元素
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (board[i][j] == 'R') {
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


    }
    private void dfs(char[][] board,int x,int y) {
        if (inArea(x,y) && board[x][y] == 'O') {
            board[x][y] = 'R';
            for (int i = 0;i < 4;i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                dfs(board,newX,newY);
            }
        }
    }
    // 判断所给坐标是否在有效范围内
    private boolean inArea(int x,int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}