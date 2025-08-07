/**
 * leetcode438 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 滑动窗口
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(),  pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount,pCount)) {
            res.add(0);
        }
        for (int i = 0;i < sLen - pLen;i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount,pCount)) {
                res.add(i + 1);
            }
        }
        return res;

    }

}
