import java.util.Arrays;

/**
 * 参考题解：
 * https://leetcode.cn/problems/target-sum/solution/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-s1cx/
 */
public class Solution1 {

    private int[] nums;
    private int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {
            return 0;
        }
        // 背包容量
        int m = s / 2;
        int n = nums.length;
        this.nums = nums;
        memo = new int[n][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int res = dfs(n - 1, m);
        return res;

    }

    private int dfs(int i, int c) {
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }
        if (memo[i][c] != -1) {
            return memo[i][c];
        }
        if (c < nums[i]) {
            return memo[i][c] = dfs(i - 1, c);
        }
        return memo[i][c] = dfs(i - 1, c) + dfs(i - 1, c - nums[i]);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution1.findTargetSumWays(nums, 3));
    }
}
