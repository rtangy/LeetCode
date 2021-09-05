/**
 * leetcode27: https://leetcode-cn.com/problems/remove-element/
 * [0,k) 中存放遍历过的不等于 val 的元素
 */
public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;

    }
}
