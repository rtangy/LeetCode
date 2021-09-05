// source https://leetcode.com/problems/word-search/description/

/***
 * 回溯
 * Time complexity: O(m*n*m*n)
 * Space complexity: O(m*n)
 *
 */
public class Solution {
    // 顺时针顺序
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;// m 表示行 n 表示列
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        assert (m > 0);
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从 board[x][y] 开始，寻找 word[index...word.length()]
    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        // 递归终止条件
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            // 从 startX，startY 出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    // 判断坐标是否越界
    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] b1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        String words[] = {"ABCCED", "SEE", "ABCB"};
        for (int i = 0; i < words.length; i++)
            if ((new Solution()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if ((new Solution()).exist(b2, "AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
