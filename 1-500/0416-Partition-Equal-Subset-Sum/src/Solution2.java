/**
 * 题解：https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2
 * 空间优化 倒着赋值
 */
public class Solution2 {
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
        boolean[] dp = new boolean[target + 1];

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1;i < n;i++) {
            for (int j = target;j >= 0;j--) {
                // 倒着计算，防止「上一行」的状态值被覆盖
                if (nums[i] <= j) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
}
