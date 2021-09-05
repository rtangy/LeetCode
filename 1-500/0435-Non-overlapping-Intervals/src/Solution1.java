import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 * 动态规划
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n)
 */

public class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 按照左端点排序，如果左区间相同，则按右端点排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        // memo[i] 表示以 intervals[i] 为结尾的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return intervals.length - res;
    }
}
