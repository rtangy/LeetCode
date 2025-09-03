import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题解：灵神
 * https://leetcode.cn/problems/course-schedule/solutions/2992884/san-se-biao-ji-fa-pythonjavacgojsrust-by-pll7/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }
        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回 true 表示找到了环
     *
     * @param x
     * @param g
     * @param colors
     * @return
     */
    private boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1;
        for (int y : g[x]) {
            if (colors[y] == 1 || colors[y] == 0 && dfs(y, g, colors)) {
                return true;
            }
        }
        // 完全访问完毕
        colors[x] = 2;
        // 没有找到环
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prerequisites = new int[][]{{0,1},{2,1},{3,2},{4,3},{2,4}};
        boolean b = solution.canFinish(5, prerequisites);
    }
}
