import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-paths/solutions/5772/dong-tai-gui-hua-by-powcai-2
 */
public class Solution2 {
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = pre[j] + cur[j - 1];
            }
            pre = cur.clone();
        }
        return pre[n - 1];

    }
}
