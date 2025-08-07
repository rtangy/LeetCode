public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int step = 0;
        int start = 0;
        int end = 1;
        while(end < len) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            step++;
        }
        return step;
    }
}
