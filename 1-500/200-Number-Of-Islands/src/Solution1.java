/**
 * /// Source : https://leetcode.com/problems/number-of-islands/description/
 * /// Floodfill - DFS
 * /// Recursion implementation
 * ///
 * /// Time Complexity: O(n*m)
 * /// Space Complexity: O(n*m)
 */
public class Solution1 {
    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    private boolean[][] visited;

    boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        // 数组默认值为 false
        visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;

    }

    // 从 grid[x][y] 位置开始，进行 floodFill
    // 保证 (x,y)合法，且 grid[x][y] 是没有被访问过的陆地
    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            // 若新的位置不越界且未被访问过并且为陆地
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }
}
