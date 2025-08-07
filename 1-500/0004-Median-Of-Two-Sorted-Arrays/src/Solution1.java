/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/2950686/tu-jie-xun-xu-jian-jin-cong-shuang-zhi-z-p2gd/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 交换 nums1 和 nums2，保证下面的i是可以从 0 开始枚举
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        // 最左边插入 -∞
        a[0] = b[0] = Integer.MIN_VALUE;
        // 最右边插入 +∞
        a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
        System.arraycopy(nums1, 0, a, 1, m);
        System.arraycopy(nums2, 0, b, 1, n);

        // 枚举 nums1 有 i 个数在第一组
        // 那么 nums2 有 j = (m + n + 1) / 2 - i 个数在第一组
        int i = 0;
        int j = (m + n + 1) / 2;
        while (true) {
            if (a[i] <= b[j + 1] && a[i + 1] > b[j]) {
                // 第一组的最大值
                int max1 = Math.max(a[i], b[j]);
                // 第二组的最小值
                int min2 = Math.min(a[i + 1], b[j + 1]);
                return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
            }
            i++;
            j--;
        }
    }
}
