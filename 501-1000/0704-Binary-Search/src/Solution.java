// source https://leetcode-cn.com/problems/binary-search/

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // [left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 查找到了指定元素
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {// nums[mid] > target
                right = mid - 1;
            }
        }
        return -1;
    }
}
