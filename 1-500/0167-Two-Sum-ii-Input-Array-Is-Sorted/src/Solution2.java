/**
 * leetcode 167 : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 * 利用二分查找法在数组中查找指定元素
 */
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length - 1;i++) {
            int j = 0;
            if ((j = binarySearch(numbers,i + 1,target - numbers[i])) != -1) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }
        }
        return  res;
    }

    /**
     * 二分查找法，若并未查找到目标元素，则返回 -1
     * @param nums
     * @param start
     * @param target
     * @return
     */
    private int binarySearch(int[] nums,int start,int target) {
        int left = start;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }else if (target < nums[mid]) {
                right = mid - 1;
            }else { // target > nums[mid]
                left = mid + 1;
            }
        }
        return -1;
    }

}
