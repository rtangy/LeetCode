/**
 * Source : https://leetcode.com/problems/assign-cookies/description/
 */

import java.util.Arrays;

/// Greedy Algorithm
/// Serve least greedy children first
/// Time Complexity: O(nlogn)
/// Space Complexity: O(1)
public class Solution2 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        int res = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                res++;
                gi++;
            }
            si++;
        }
        return res;
    }
}
