/**
 * 对撞指针
 */
public class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }

    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
