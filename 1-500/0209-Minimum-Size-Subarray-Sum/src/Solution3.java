public class Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = -1;// nums[l,r]为滑动窗口
        // 长度值结果
        int res = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < target) {
                sum += nums[++r];
            }else {
                sum -= nums[l++];
            }
            if (sum >= target) {
                res = Math.min(res,r - l + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        int target = 7;
        int res = new Solution3().minSubArrayLen(target, arr);
        System.out.println(res);

    }
}
