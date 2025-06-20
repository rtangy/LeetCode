import java.sql.Array;
import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 第一步：统计每个元素的出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int maxCnt = Collections.max(cnt.values());

        // 第二步：把出现次数相同的元素放到同一个桶里
        List<Integer>[] buckets = new ArrayList[maxCnt + 1];
        Arrays.setAll(buckets, i -> new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        // 第三步：倒序遍历 buckets,把出现次数前k大的元素加入答案
        int[] ans = new int[k];
        int j = 0;
        for (int i = maxCnt; i >= 0 && j < k; i--) {
            for (int x : buckets[i]) {
                ans[j++] = x;
            }
        }
        return ans;
    }
}
