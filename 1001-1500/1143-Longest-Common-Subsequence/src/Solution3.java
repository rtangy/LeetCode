/**
 * Source : https://leetcode.com/problems/longest-common-subsequence/
 */
/// Dynamic Programming with Space Optimization
/// Time Complexity: O(n * m)
/// Space Complexity: O(m)
public class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[2][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[(i + 1) % 2][j + 1], 1 + dp[i % 2][j]);
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j + 1]);
                }
            }
        }
        return dp[n % 2][m];

    }
}
