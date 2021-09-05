/**
 * leetcode1 https://leetcode.com/problems/two-sum/description/
 *  Brute Force
 *  Time Complexity: O(n^2)
 *  Space Complexity: O(1)
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0;i < nums.length - 1;i++) {
            for (int j = i + 1;j < nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalStateException("The input has no solution.");
    }
}
