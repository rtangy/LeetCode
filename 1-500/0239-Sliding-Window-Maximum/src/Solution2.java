/**
 * 数组版本
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int[] queue = new int[len];
        int head = 0;
        int tail = -1;

        for (int i = 0; i < len; i++) {

            while (head <= tail && nums[queue[tail]] <= nums[i]) {
                tail--;
            }
            // 1. 右边入
            queue[++tail] = i;
            // 2. 左边出
            if (queue[head] <= i - k) {
                head++;
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾是单调递减，所以窗口最大值就在队首
                res[i - k + 1] = nums[queue[head]];
            }
        }
        return res;
    }
}
