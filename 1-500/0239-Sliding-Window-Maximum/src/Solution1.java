import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {

            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 1. 右边入
            queue.addLast(i);
            // 2. 左边出
            if (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾是单调递减，所以窗口最大值就在队首
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
