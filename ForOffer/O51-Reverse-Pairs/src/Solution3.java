/**
 * 相对 Solution2 方法
 * 避免维护 res 成员变量
 */
public class Solution3 {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    /**
     * @param nums
     * @param l
     * @param r
     * @param temp
     * @return 在 l 到 r 区间中逆序对的个数
     */
    private int sort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return 0;
        }
        int res = 0;
        int mid = l + (r - l) / 2;
        res += sort(nums, l, mid, temp);
        res += sort(nums, mid + 1, r, temp);

        if (nums[mid] > nums[mid + 1]) {
            res += merge(nums, l, mid, r, temp);
        }
        return res;
    }

    private int merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int i = l, j = mid + 1, res = 0;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > r) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                // 当正在遍历的右半区间元素小于左边区间元素时，此元素会与左
                // 半区间所有还未遍历的元素形成逆序对
                res += mid - i + 1;
                nums[k] = temp[j];
                j++;
            }
        }
        return res;
    }

}
