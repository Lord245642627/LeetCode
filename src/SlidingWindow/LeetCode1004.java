package SlidingWindow;

/**
 * @author Lord Camelot
 * @date 2024/4/1
 * @description LeetCode1004 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class LeetCode1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                index++;
                while (index > k) {
                    left++;
                    if (nums[left - 1] == 0) {
                        index--;
                    }
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
