public class Solution1 {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
