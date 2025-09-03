import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2
 */
public class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 统计新鲜橘子的个数
                    fresh++;
                } else if (grid[i][j] == 2) {
                    // 一开始就腐烂的橘子
                    q.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (fresh > 0 && !q.isEmpty()) {
            // 经过一分钟
            ans++;
            List<int[]> temp = q;
            q = new ArrayList<>();
            for (int[] pos : temp) {
                for (int[] d : DIRECTIONS) {
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];
                    // 新鲜橘子
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        fresh--;
                        // 变成腐烂橘子
                        grid[i][j] = 2;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : ans;

    }
}
