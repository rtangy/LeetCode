public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return nums.length;
        }
        // [0,slow) 存放满足条件的数组
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            // 若 nums[fast] == nums[slow - 2]
            // 由于数组是有序的，则 nums[fast] == nums[slow - 1]

            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }
}