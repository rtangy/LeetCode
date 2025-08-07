/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solutions/38477/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/?envType=study-plan-v2
 * 方法一：暴力解法
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // 有可能不发生交易，因此结果集的初始值设置为0
        int res = 0;
        // 枚举所有发生一次交易的股票差
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;

    }
}
