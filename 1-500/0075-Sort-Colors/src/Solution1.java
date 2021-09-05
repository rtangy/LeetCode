/**
 * leetcode75 https://leetcode-cn.com/problems/sort-colors/
 * 使用计数排序
 *
 */
public class Solution1 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] < 0 || nums[i] > 2) {
                throw new IllegalArgumentException("Parameter is illegal.");
            }
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0;i < count[0];i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i <count[1];i++) {
            nums[index++] = 1;
        }
        for (int i = 0;i < count[2];i++) {
            nums[index++] = 2;
        }

    }

}
