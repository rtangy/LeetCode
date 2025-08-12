/**
 * 1. 记录字符串 t 中各字符的数量
 * 2. 从左到右遍历字符串 s 找到包含 t 的字符串
 * 3. 缩小左区间找到最小子字符串
 */
public class Solution1 {
    public String minWindow(String s, String t) {
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        char[] sCharArray = s.toCharArray();
        int m = sCharArray.length;
        int ansLeft = -1;
        int ansRight = m;

        int left  = 0;
        for (int right = 0; right < m; right++) {
            cntS[sCharArray[right]]++;
            while (isCovered(cntS,cntT)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[sCharArray[left]]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);

    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A';i <= 'Z';i++) {
            if (cntS[i] <= cntT[i]) {
                return false;
            }
        }
        for (int i = 'a';i <= 'z';i++) {
            if (cntS[i] <= cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
