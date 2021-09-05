import java.util.Random;

/**
 * leetcode215 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 利用 快排的 partition 位置
 */
public class Solution1 {
    private static final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, 0, nums.length - 1, nums.length - k);
    }

    private int selectK(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (p == k) {
            return nums[p];
        }
        if (k < p) {
            return selectK(nums, l, p - 1, k);
        }
        return selectK(nums, p + 1, r, k);
    }

    private int partition(int[] nums, int l, int r) {
        // 生成 [l,r] 之间的随机索引
        int index = l + random.nextInt(r - l + 1);
        swap(nums, l, index);
        // arr[l+1,i-1] <= v arr[j+1,r] >= v
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            while (j >= i && nums[j] > nums[l]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
