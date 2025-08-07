/**
 * 将数组视为哈希表
 * 要找的数一定在 [1,N+1] 左闭右闭这个区间里
 */
public class Solution3 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0;i < len;i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums,i,nums[i] - 1);
            }
        }
        // [1, -1, 3, 4]
        for (int i = 0;i < len;i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;

    }
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
