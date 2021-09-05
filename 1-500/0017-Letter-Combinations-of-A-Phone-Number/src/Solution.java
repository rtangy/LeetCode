import java.util.ArrayList;
import java.util.List;

/**
 * leetcode17: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 *
 * 回溯算法
 */
public class Solution {
    // 电话号码的数字字母映射
    private static final String[] phoneMap = {
            "",//0
            "",//1
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if (digits == null ||  digits.length() == 0) {
            return res;
        }

        StringBuilder sb = new StringBuilder(digits.length());
        backtracking(digits,0,sb);
        return res;
    }
    private void backtracking(String digits,int index,StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = phoneMap[digits.charAt(index) - '0'];
        for (int i = 0;i < str.length();i++) {
            // 追加字符串
            sb.append(str.charAt(i));
            backtracking(digits,index + 1,sb);
            // 恢复状态
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

    }
}