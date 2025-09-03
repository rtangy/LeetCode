/**
 *
 */
public class Solution1 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    dfs(grid, row, column);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != '1') {
            return;
        }
        // 标识已遍历过的陆地
        grid[row][column] = '2';
        dfs(grid,row - 1,column);
        dfs(grid,row + 1,column);
        dfs(grid,row,column - 1);
        dfs(grid, row, column + 1);
    }

}
