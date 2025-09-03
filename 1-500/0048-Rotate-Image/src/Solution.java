/**
 * 转置 + 翻转
 * 1 2 3    1 4 7    7 4 1
 * 4 5 6 -> 2 5 8 -> 8 5 2
 * 7 8 9    3 6 9    9 6 3
 *
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 第一步:转置
        for (int i = 0; i < n; i++) {
            for (int j = 0;j < i;j++) {
                // 遍历对角线下方元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 行翻转
        for (int[] row : matrix) {
            for (int j = 0; j < n / 2; j++) {
                int temp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = temp;
            }
        }

    }

}
