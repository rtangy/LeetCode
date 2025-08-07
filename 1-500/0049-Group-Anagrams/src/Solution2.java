import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Collection<List<String>> lists = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })).values();

        return new ArrayList<>(lists);
    }

}
