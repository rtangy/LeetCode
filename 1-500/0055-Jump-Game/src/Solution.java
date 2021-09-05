/**
 * https://leetcode-cn.com/problems/jump-game/
 * 不去考虑跳法，而去考虑最远能够跳到什么位置
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // 贪心算法
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            // 当前在 第 i 步，还能跳 nums[i]阶梯
            cover = Math.max(nums[i] + i, cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
