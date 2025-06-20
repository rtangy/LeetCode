public class Solution3 {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int candNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (candNum == nums[i]) {
                count++;
            } else if (--count == 0) {
                candNum = nums[i];
                count = 1;
            }
        }
        return candNum;

    }

}
