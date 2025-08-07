import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/partition-labels/solutions/2806706/ben-zhi-shi-he-bing-qu-jian-jian-ji-xie-ygsn8/?envType=study-plan-v2
 */
public class Solution1 {
    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            // 每个字母最后出现的下标
            last[charArray[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            // 更新当前区间右端点的最大值
            end = Math.max(end, last[charArray[i] - 'a']);
            // 当前区间合并完毕
            if (end == i) {
                // 区间长度加入答案
                ans.add(end - start + 1);
                // 下一个区间的左端点
                start = i + 1;
            }
        }
        return ans;

    }

}
