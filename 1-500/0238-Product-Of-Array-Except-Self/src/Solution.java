/**
 * https://leetcode.cn/problems/product-of-array-except-self/solutions/11472/product-of-array-except-self-shang-san-jiao-xia-sa/?envType=study-plan-v2
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return new int[0];
        }
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1;i < len;i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = len - 2;i >= 0;i--) {
            temp *= nums[i + 1];
            ans[i] *= temp;
        }
        return ans;
    }
}
