import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表（空间复杂度不符合要求）
 */
public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = 1; i <= len; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }

        }
        return len + 1;
    }
}
