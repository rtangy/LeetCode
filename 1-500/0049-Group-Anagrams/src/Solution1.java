import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] counts = new int[26];
                    for (int i = 0;i < str.length();++i) {
                        counts[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0;i < counts.length;++i) {
                        if (counts[i] != 0) {
                            sb.append(i + 'a');
                            sb.append(counts[i]);
                        }
                    }
                    return sb.toString();
                })).values());
    }
}
