// source https://leetcode.com/problems/minimum-size-subarray-sum/description/

// 暴力解法
// time complexity O(n^3)
// space complexity O(1)

public class Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        if (target <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal Arguments.");
        }
        int res = nums.length + 1;
        for (int l = 0;l < nums.length;l++) {
            for (int r = l;r < nums.length;r++) {
                int sum = 0;
                for (int i = l;i <= r;i++) {
                    sum += nums[i];
                }
                if(sum >= target) {
                    res = Math.min(res,r - l + 1);
                }
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(new Solution1().minSubArrayLen(target,nums));
    }
}
