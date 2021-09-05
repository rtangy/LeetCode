/**
 * leetcode3 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = -1;
        int res = 0;
        int[] freq = new int[256];
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            }else {// 对应 freq[s.charAt(r + 1)] != 0，以及 右指针已经到达尾部
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res,r - l + 1);
        }
        return res;

    }

}
