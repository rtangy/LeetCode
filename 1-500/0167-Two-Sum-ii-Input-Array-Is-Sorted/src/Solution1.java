/**
 * leetcode167 : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 * 暴力解法
 */
public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break;
                }
            }
        }
        return res;

    }

}
