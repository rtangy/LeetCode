import java.util.Arrays;

/**
 * 参考题解：
 * https://leetcode.cn/problems/target-sum/solution/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-s1cx/
 * 1:1 翻译成递推
 */
public class Solution2 {
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

       int[][] f = new int[n+1][m + 1];
       f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= m; c++) {
                if (c < nums[i]) {
                    // 只能不选
                    f[i+1][c] = f[i][c];
                }else {
                    // 不选 + 选
                    f[i + 1][c] = f[i][c] + f[i][c - nums[i]];
                }
            }
        }
        return f[n][m];
    }



    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution1.findTargetSumWays(nums, 3));
    }
}
