import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }
        int longestSeqLen = 0;
        for (Integer num : set) {
            int currentNum = num;
            int currentLen = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                longestSeqLen = Math.max(longestSeqLen, currentLen);
            }
        }
        return longestSeqLen;
    }
}
