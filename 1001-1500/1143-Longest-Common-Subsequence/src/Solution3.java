/**
 * Source : https://leetcode.com/problems/longest-common-subsequence/
 */
/// Dynamic Programming with Space Optimization
/// Time Complexity: O(n * m)
/// Space Complexity: O(m)
public class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int n = s.length;
        int m = t.length;
        int[][] dp = new int[2][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[i % 2][j + 1], dp[(i + 1) % 2][j]);
                }
            }
        }
        return dp[n % 2][m];
    }
}
