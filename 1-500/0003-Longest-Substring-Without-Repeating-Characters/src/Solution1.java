import java.util.HashMap;
import java.util.Map;

/**
 * leetcode3 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // eg: abcdba，注意不在滑动窗口内不用移动，如第二个a
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;

    }

}
