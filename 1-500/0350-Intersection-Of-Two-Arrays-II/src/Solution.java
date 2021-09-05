import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //num:times 数字及出现次数
        Map<Integer, Integer> record = new HashMap<>();
        for (int num : nums1) {
            if (!record.containsKey(num)) {
                record.put(num, 1);
            } else {
                record.put(num, record.get(num) + 1);
            }
        }
        List<Integer> results = new ArrayList<>();
        for (int num : nums2) {
            // 若 map 中存在
            if (record.containsKey(num) && record.get(num) > 0) {
                results.add(num);
                // 出现的频次-1
                record.put(num, record.get(num) - 1);
            }
        }
        int[] ret = new int[results.size()];
        int index = 0;
        for (Integer num : results) {
            ret[index++] = num;
        }
        return ret;
    }
}
