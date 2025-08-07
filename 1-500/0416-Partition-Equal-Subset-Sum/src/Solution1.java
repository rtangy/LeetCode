/**
 * 题解：https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2
 */
public class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        // dp[i][j]: 区间 nums[0...i] 里是否存在若干个元素为j
        boolean[][] dp = new boolean[n][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1;i < n;i++) {
            for (int j = 0;j <= target;j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[n - 1][target];
    }
}
