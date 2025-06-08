package src;

import java.util.Random;

/**
 * 双路快速排序
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
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1;// le: less equals
        int ge = right;// ge: greater equals
        // all in nums[left + 1..le) <= pivot
        // all in nums(ge..right] >= pivot
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if (le >= ge) {
                break;
            }
            // le 来到了第一个大于等于 pivot 的位置
            // ge 来到了第一个小于等于 pivot 的位置
            swap(nums,le,ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
