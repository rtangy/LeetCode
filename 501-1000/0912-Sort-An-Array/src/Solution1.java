package src;

import java.util.Random;

/**
 * 快速排序写法1，无法通过全部测试用例
 * 选择数组中的第一个元素作为 pivot
 */
class Solution1 {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);

    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums,left,randomIndex);
        int pivot = nums[left];
        int j = left;

        // all in nums[left + 1..j] <= pivot
        // all in nums[j+1,i) > pivot
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
