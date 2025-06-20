public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 第一步：从右向左找出第一个小于右侧相邻数字的数 nums[i]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果找到了，进入第二步；否则跳过第二步，反转整个数组
        if (i >= 0) {
            int j = n - 1;
            // 第二步：从右向左找到 nums[i] 右边最小的大于 nums[i] 的数 nums[j]
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }
        // 第三步：反转 nums[i+1:]（如果上面跳过第二步，此时 i = -1）
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex++, endIndex--);
        }
    }
}
