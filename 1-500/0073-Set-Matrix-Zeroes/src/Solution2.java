/**
 * 题解同 Solution1
 *
 * 空间复杂度O(1)
 * 关键思想: 用matrix第一行和第一列记录该行该列是否有0,作为标志位
 * 但是对于第一行,和第一列要设置一个标志位,为了防止自己这一行(一列)也有0的情况
 */
public class Solution2 {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        boolean row0Flag = false;
        boolean column0Flag = false;

        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                row0Flag = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                column0Flag = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0Flag) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }
        if (column0Flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
