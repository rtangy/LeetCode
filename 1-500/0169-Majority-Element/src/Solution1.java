import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
