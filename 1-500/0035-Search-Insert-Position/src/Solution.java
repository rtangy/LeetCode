// source https://leetcode-cn.com/problems/search-insert-position/
/**
 * 二分查找
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 若数组末端元素小于目标值，则应插入到尾部
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else { // nums[mid] >= target
                right = mid;
            }
        }
        return left;

    }

}
