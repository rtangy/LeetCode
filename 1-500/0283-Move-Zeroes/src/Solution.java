/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * <p>
 * 是否可能将非零元素放置到正确位置的同时，将零元素也同时放置到了合适的位置呢?
 * 此外数组首部是非零元素的情况下，可以避免交换操作
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        // k :[0,k) 保存所有当前已经遍历过的非0元素
        int k = 0;
        // 遍历到第 i 个元素后，保证 [0,i] 中的所有非0元素
        // 都按照顺序排列在[0,k) 中
        // 同时 [k,i] 为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k++;
            }
        }
    }

    /**
     * 交换数组中的两元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        (new Solution()).moveZeroes(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
