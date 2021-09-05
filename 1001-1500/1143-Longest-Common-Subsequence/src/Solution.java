import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */

/// Memory Search
/// Time Complexity: O(n * m)
/// Space Complexity: O(n * m)

public class Solution {
    private int n, m;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        int[][] dp = new int[n][m];
        // 填充数组
        for (int i = 0;i < n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return dfs(text1, 0, text2, 0, dp);

    }

    private int dfs(String s1, int i, String s2, int j, int[][] dp) {
        if (i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            res = Math.max(res, 1 + dfs(s1, i + 1, s2, j + 1, dp));
        }else {
            res = Math.max(dfs(s1, i + 1, s2, j, dp), dfs(s1, i, s2, j + 1, dp));
        }
        return dp[i][j] = res;

    }
}
