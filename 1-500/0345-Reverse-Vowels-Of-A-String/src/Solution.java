import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * 指针碰撞
 */
public class Solution {
    private static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int l = 0;
        int r = charArr.length - 1;
        while (l < r) {
            while (l < r && !vowels.contains(charArr[l])) {
                l++;
            }
            while (l < r && !vowels.contains(charArr[r])) {
                r--;
            }
            swap(charArr, l, r);
            l++;
            r--;
        }
        return new String(charArr);

    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

}
