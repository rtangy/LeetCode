import java.util.stream.IntStream;

/**
 * leetcode75 https://leetcode-cn.com/problems/sort-colors/
 * 使用计数排序
 *
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] < 0 || nums[i] > 2) {
                throw new IllegalArgumentException("Parameter is illegal.");
            }
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0;i < count.length;i++) {
            for (int j = 0;j < count[i];j++) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] arr = {2,0,2,1,1,0};
        solution2.sortColors(arr);
        IntStream.range(0,arr.length).forEach(i -> System.out.print(arr[i] + " "));
    }

}
