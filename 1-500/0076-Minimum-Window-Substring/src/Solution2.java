public class Solution2 {
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
