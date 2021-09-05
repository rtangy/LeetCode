/**
 * leetcode167 : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 利用数组是有序的性质，利用对撞指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int[] res = {l + 1,r + 1};
                break;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            }
        }
        throw new IllegalArgumentException("The input has no solution.");
    }
}
