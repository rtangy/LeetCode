public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int point1 = 0;
        int point2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (point1 < m && point2 < n) {
                if (nums1[point1] <= nums2[point2]) {
                    result[i] = nums1[point1++];
                } else {
                    result[i] = nums2[point2++];
                }
            } else if (point1 < m) { // 证明 point2 > m
                result[i] = nums1[point1++];
            } else {
                result[i] = nums2[point2++];
            }
        }
        System.arraycopy(result, 0, nums1, 0, nums1.length);
    }
}
