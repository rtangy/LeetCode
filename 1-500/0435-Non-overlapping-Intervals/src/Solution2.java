import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 * 贪心算法
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
public class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 先按右端点排序，如果右端点相同，则按左端点大小顺序排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {
                res++;
                pre = i;
            }
        }
        return intervals.length - res;
    }

}
