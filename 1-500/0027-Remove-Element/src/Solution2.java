/**
 * leetcode27: https://leetcode-cn.com/problems/remove-element/
 *
 * Move the deleted element to the last
 * This method would be save the unnecessary copy when the removed element is rare.
 */

public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int newl = nums.length;
        int i = 0;
        while (i < newl)
            if (nums[i] == val)
                nums[i] = nums[--newl];
            else
                i++;

        return newl;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] arr = {2, 2, 2, 2};
        int i = solution2.removeElement(arr, 3);
    }
}
