/**
 * leetcode438 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 滑动窗口
 */

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 字符串 s 长度小于 p 长度的情况
        if (s.length() < p.length()) {
            return res;
            s.toCharArray()
        }
        if (p.length() == 0) {
            throw new IllegalArgumentException("Illegal parameter p.");
        }
        // 填充字符串 p 出现的频次
        int[] freqP = new int[26];
        for (int i = 0;i < p.length();i++) {
            freqP[p.charAt(i) - 'a']++;
        }
        int[] freqS = new int[26];
        int l = 0;
        int r = -1;
        while (r + 1 < s.length()) {
            r++;
            freqS[s.charAt(r)-'a']++;
            if (r - l + 1 > p.length()) {
                freqS[s.charAt(l++) - 'a']--;
            }
            if (r - l + 1 == p.length() && same(freqS,freqP)) {
                res.add(l);
            }
        }
        return res;


    }
    // 判断两数组频次是否完全相同
    private boolean same(int[] freqS,int[] freqP) {
        for (int i = 0;i < 26;i++) {
            if (freqS[i] != freqP[i]) {
                return false;
            }
        }
        return true;
    }
}
