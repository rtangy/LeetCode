public class Solution2 {
    private int res = 0;

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        res = 0;
        sort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void sort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid, temp);
        sort(nums, mid + 1, r, temp);

        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r, temp);
        }
    }

    private void merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > r) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                res += mid - i + 1;
                nums[k] = temp[j];
                j++;
            } else {
                nums[k] = temp[i];
                i++;
            }
        }
    }

}
