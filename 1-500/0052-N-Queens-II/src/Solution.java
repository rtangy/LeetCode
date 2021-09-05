import java.util.LinkedList;

/**
 * 52. N-Queens-ii
 * https://leetcode-cn.com/problems/n-queens-ii/
 * 时间复杂度: O(n^n)
 * 空间复杂度: O(n)
 */
public class Solution {
    private int res;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public int totalNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        LinkedList<Integer> row = new LinkedList();
        res = 0;
        putQueen(n, 0, row);
        return res;

    }

    private void putQueen(int n, int index, LinkedList<Integer> row) {
        if (index == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index - i + n - 1] && !dia2[index + i]) {
                row.addLast(i);
                col[i] = true;
                dia1[index - i + n - 1] = true;
                dia2[index + i] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index - i + n - 1] = false;
                dia2[index + i] = false;
            }
        }
    }
}
