/**
 * leetcode https://leetcode-cn.com/problems/container-with-most-water/
 * 指针碰撞
 * 思路：
 * 面积是由 两个指针指向的数字较小者 * 两指针之间的距离决定
 * 若移动两指针中的较大者，则 两指针指向数字的较小者不变 * 距离减少
 * 因此得使 两指针指向数组的较小者发生变化
 *
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                maxArea = Math.max(maxArea, (r - l) * height[l++]);
            }else {
                maxArea = Math.max(maxArea, (r - l) * height[l++]);
            }

        }
        return maxArea;

    }
}