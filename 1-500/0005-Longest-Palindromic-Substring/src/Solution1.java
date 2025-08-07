/**
 * 暴力解法
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] charArray =  s.toCharArray();

        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int  i = 0;i < len - 1;i++) {
            for (int j = i + 1;j < len;j++) {
                if (j - i + 1 > maxLen && validPalindrome(charArray,i,j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);

    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindrome(char[] charArray,int left,int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
