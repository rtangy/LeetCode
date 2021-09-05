/**
 *  Source : https://leetcode.com/problems/is-subsequence/
 */
public class Solution1 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return n == i;
    }

}
