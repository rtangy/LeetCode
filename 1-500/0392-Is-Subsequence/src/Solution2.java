/**
 *  Source : https://leetcode.com/problems/is-subsequence/
 */
public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        // f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Solution2().isSubsequence(s, t));
    }
}
