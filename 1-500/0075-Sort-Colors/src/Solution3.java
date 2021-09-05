/**
 * 使用快速排序
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution3 {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        // nums[0,zero] == 0, nums[two,n-1] == 2
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                if (nums[i] != 0) {
                    throw new IllegalArgumentException("parameter is illegal.");
                }
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
