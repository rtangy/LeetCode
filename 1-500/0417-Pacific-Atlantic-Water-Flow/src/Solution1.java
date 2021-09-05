import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 417 https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * floodFill
 */
public class Solution1 {

    private int m,n;
    private boolean[][] pacific,atlantic;
    private int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        m = heights.length;
        n = heights[0].length;

        // 太平洋
        pacific = new boolean[m][n];
        // 大西洋
        atlantic = new boolean[m][n];

        // 左右
        for (int i = 0;i < m;i++) {
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,n - 1);
        }
        // 上下
        for (int j = 0;j < n;j++) {
            dfs(heights,pacific,0,j);
            dfs(heights,atlantic,m - 1,j);
        }
        // 遍历得到结果
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights,boolean[][] visited,int x,int y) {
        visited[x][y] = true;
        for (int i = 0;i < 4;i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            // 从太平洋与大西洋寻找，若待查找坐标位置大于等于此位置坐标，则可从目标位置到达此位置
            if (inArea(newX,newY) && !visited[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                dfs(heights,visited,newX,newY);
            }
        }
    }

    // 判断指定坐标值是否在有效范围内
    private boolean inArea(int x,int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    private static void printList(List<List<Integer>> list) {
        for (List<Integer> e : list) {
            System.out.println("（" + e.get(0) + ","+e.get(1) + ")");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   2,   2,   3,  5},
                {3,   2,   3,   4,  4},
                {2,   4,   5,   3,  1},
                {6,   7,   1,   4,  5},
                {5,   1,   1,   2,  4}
        };
        List<List<Integer>> res = (new Solution1()).pacificAtlantic(matrix);
        printList(res);
    }

}