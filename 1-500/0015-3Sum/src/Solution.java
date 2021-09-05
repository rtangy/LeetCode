import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// source: https://leetcode-cn.com/problems/3sum/

/**
 * two pointer technique
 * time complexity : O(n^2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1,hi = nums.length - 1,sum = 0 - nums[i];
                // 双指针
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        // 跳过重复元素
                        while (lo < hi && nums[lo] == nums[++lo]);
                        while (lo < hi && nums[hi] == nums[--hi]);
                    }else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    }else { // nums[lo] + nums[hi] > sum
                        hi--;
                    }
                }
            }
        }
        return res;

    }
}
