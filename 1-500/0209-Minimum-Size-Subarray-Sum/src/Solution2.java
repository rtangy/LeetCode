// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/description/
//
// 优化暴力解
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        if (target <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal Argument.");
        }
        // sum[i] 存放 nums[0...i-1]的和
        // 通过多一位 sum[0] 可以保证 l = 0 不越界
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for(int i = 1;i <= nums.length;i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int res = nums.length + 1;
        for (int l = 0;l < nums.length;l++) {
            for (int r = 0;r < nums.length;r++) {
                if (sums[r + 1]-sums[l] >= target) {
                    res = Math.min(res,r - l + 1);
                }
            }
        }
        if(res == nums.length + 1)
            return 0;

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution2()).minSubArrayLen(s, nums));
    }

}
