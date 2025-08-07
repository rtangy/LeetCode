public class Solution2 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 以 nums[i - 1] 结尾的连续子数组的最大乘积
        int preMax = nums[0];
        // 以 nums[i - 1] 结尾的连续子数组的最小乘积
        int preMin = nums[0];

        int curMax;
        int curMin;
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                curMin = Math.min(preMin * nums[i], nums[i]);
                curMax = Math.max(preMax * nums[i], nums[i]);
            }else {// nums[i] < 0
                curMin = Math.min(preMax * nums[i], nums[i]);
                curMax = Math.max(preMin * nums[i], nums[i]);
            }
            res = Math.max(res, curMax);
            preMin = curMin;
            preMax = curMax;
        }
        return res;
    }
}
