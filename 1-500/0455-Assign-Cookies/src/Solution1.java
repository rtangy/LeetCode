import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/description/
 */
/// Greedy Algorithm
/// Serve most greedy children first
/// Time Complexity: O(nlogn)
/// Space Complexity: O(1)


public class Solution1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
            }
            gi--;
        }
        return res;
    }

}
