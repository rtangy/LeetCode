import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int l = 0,r = matrix[0].length - 1,t = 0,b = matrix.length - 1,x = 0;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r;i >= l;i--) {
                res.add(matrix[b][i]);
            }
            if (--b < t) {
                break;
            }
            for (int i = b;i >= t;i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

}
