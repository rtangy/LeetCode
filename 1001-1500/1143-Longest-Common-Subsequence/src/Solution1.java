import java.util.Arrays;

/// 记忆化搜索+递归
/// Time Complexity: O(n * m)
/// Space Complexity: O(n * m)

public class Solution1 {
    private char[] s, t;
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();
        int m = s.length;
        int n = t.length;
        memo = new int[m][n];
        for (int[] row : memo) {
            // -1 表示没有计算过
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, n - 1);


    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s[i] == t[j]) {
            return memo[i][j] = dfs(i - 1, j - 1) + 1;
        } else {
            return memo[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
        }
    }
}
