import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topC = stack.pop();
                char match = ' ';

                if (topC == '(') {
                    match = ')';
                } else if (topC == '{') {
                    match = '}';
                } else if (topC == '[') {
                    match = ']';
                }
                // 如果不匹配
                if (c != match) {
                    return false;
                }
            }

        }
        // 左括号未被右括号匹配到
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

}
