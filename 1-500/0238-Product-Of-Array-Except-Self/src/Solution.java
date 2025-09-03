/**
 * https://leetcode.cn/problems/product-of-array-except-self/solutions/11472/product-of-array-except-self-shang-san-jiao-xia-sa/?envType=study-plan-v2
 *
 * 下三角形 * 上三角形 主对角线为1
 *
 *
 *              1 3 4 5
 *              2 1 4 5
 * 2 3 4 5 ---> 2 3 1 5
 *              2 3 4 1
 *
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
