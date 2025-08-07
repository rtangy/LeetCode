import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 * 借助栈的数据结构 & 哨兵的思想
 */
public class Solution2 {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;

        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < len; i++) {
            while (heights[i] < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                res = Math.max(res, curWidth * curHeight);
            }
            stack.push(i);
        }
        return res;
    }
}
