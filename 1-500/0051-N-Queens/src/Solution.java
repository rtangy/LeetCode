import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/description/
 * 时间复杂度: O(n^n)
 * 空间复杂度: O(n)
 */
public class Solution {

    private boolean[] col; // 列是否被占用
    private boolean[] dia1; // 主对角线是否被占用
    private boolean[] dia2; // 副对角线是否被占用
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        List<Integer> row = new LinkedList<>();

        putQueen(n, 0, row);
        return res;

    }


    private void putQueen(int n, int index, List<Integer> row) {
        // 递归终止条件
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index - i + n - 1] && !dia2[index + i]) {
                row.add(i);
                col[i] = true;
                dia1[index - i + n - 1] = true;
                dia2[index + i] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index - i + n - 1] = false;
                dia2[index + i] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    /**
     * 生成题目要求的格式
     *
     * @param n
     * @param row
     * @return
     */
    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] charArr = new char[n];
            Arrays.fill(charArr, '.');
            charArr[row.get(i)] = 'Q';
            board.add(new String(charArr));
        }
        return board;

    }

    private static void printBoard(List<String> board) {
        for (String s : board)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for (List<String> board : res)
            printBoard(board);
    }
}
