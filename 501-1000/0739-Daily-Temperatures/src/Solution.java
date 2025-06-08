package src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] resArr = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0;i < len;++i) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                resArr[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return resArr;

    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        int[] res = solution.dailyTemperatures(temperatures);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
