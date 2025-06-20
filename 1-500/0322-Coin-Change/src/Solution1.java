import java.util.Arrays;

public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        // 状态定义: dp[i]表示凑成金额 i 所需的最少硬币数量

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // dp[i-coin] != amount + 1 表示金额是可凑出的
                if (i - coin >= 0 && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
