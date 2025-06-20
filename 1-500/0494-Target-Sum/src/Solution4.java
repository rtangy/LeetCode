/**
 * 参考题解：
 * https://leetcode.cn/problems/target-sum/solution/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-s1cx/
 * 1:1 翻译成递推
 */
public class Solution4 {
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
        int[] f = new int[m+1];
        f[0] = 1;
        for (int x : nums) {
            for (int c = m; c >= x; c--) {
                f[c] += f[c - x];
            }
        }
        return f[m];
    }



    public static void main(String[] args) {
        Solution4 solution1 = new Solution4();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution1.findTargetSumWays(nums, 3));
    }
}
