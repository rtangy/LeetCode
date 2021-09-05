import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
/**
 * Hash Table
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalStateException("The input parameter is illegal.");
    }

}
