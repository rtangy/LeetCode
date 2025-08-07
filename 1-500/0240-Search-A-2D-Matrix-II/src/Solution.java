public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        // 从右上角开始
        int j = matrix[0].length - 1;
        // 还有剩余元素
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

}
