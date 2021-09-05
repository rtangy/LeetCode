import java.util.ArrayList;
import java.util.List;

// 剪枝条件，数字位数为 [4,12]
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) {
            return res;
        }
        // 存储各 ip 段
        List<String> path = new ArrayList<>();
        backtracking(s, len, 0, 0, path, res);
        return res;

    }

    private void backtracking(String s, int len, int splitTime, int begin, List<String> path, List<String> res) {
        if (begin == len) {
            if (splitTime == 4) {
                res.add(String.join(".", path));
            }
            return;
        }
        // 剪枝条件
        if ((len - begin) < (4 - splitTime) || (len - begin) > 3 * (4 - splitTime)) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            // 如果开始下标已经越界，则跳出循环
            if (begin + i >= len) {
                break;
            }
            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                path.add(String.valueOf(ipSegment));
                backtracking(s, len, splitTime + 1, begin + i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }

    }

    // 判断单独一段是否为有效 ip 地址段
    // 若并非有效 ip 段则返回 -1
    private int judgeIfIpSegment(String str, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && str.charAt(left) == '0') {
            return -1;
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + str.charAt(i) - '0';
        }
        if (res > 255) {
            return -1;
        }
        return res;
    }
}
