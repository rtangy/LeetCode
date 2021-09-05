import java.util.Arrays;
// source https://leetcode-cn.com/problems/3sum-closest

/**
 * 排序+双指针
 * time complexity O(n^2)
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 必须取其中之一
        int res = nums[0] + nums[1] + nums[2];
        // 排序
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++) {
            int lo = i + 1,hi = nums.length - 1,sum = 0;
            while (lo < hi) {
                sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum == target) {
                    return sum;
                }else if (sum < target) {
                    lo++;
                }else {
                    hi--;
                }
            }
        }
        return res;
    }
}
