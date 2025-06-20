import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题解：
 * https://leetcode.cn/problems/merge-intervals/solutions/204898/tan-xin-suan-fa-java-by-liweiwei1419-3/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        // 按照起点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 只关心当前结果集中的最后一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] currentInterval = intervals[i];
            int[] peek = res.get(res.size() - 1);
            // 当前区间左端点大于当前结果集中区间右端点
            if (currentInterval[0] > peek[1]) {
                res.add(currentInterval);
            } else {
                peek[1] = Math.max(currentInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution.merge(intervals);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
