import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode215 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 优先队列
 *
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        // 最小堆
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0;i < k;i++) {
            queue.add(nums[i]);
        }
        for (int i = k;i < nums.length;i++) {
            if (!queue.isEmpty() && nums[i] > queue.peek()) {
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return queue.peek();

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        new Solution2().findKthLargest(nums,2);
    }
}
