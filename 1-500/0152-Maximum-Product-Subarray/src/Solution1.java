/**
 *
 */
public class Solution1  {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // dp[i][0]: 以 nums[i] 结尾的连续子数组的最小值
        // dp[i][1]: 以 nums[i] 结尾的连续子数组的最大值
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
            }else {// nums[i] < 0
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
            }
        }
        // 只关系最大值，需要遍历
        int res = dp[0][1];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
