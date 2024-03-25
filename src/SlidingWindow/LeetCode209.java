package SlidingWindow;

/**
 * @author Lord Camelot
 * @date 2024/3/25
 * @description LeetCode209 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class LeetCode209 {
    // 时间复杂度 O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int cur = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            while (cur - nums[left] >= target) {
                cur -= nums[left];
                left++;
            }
            if (cur >= target) {
                ans = Math.min(ans, i - left + 1);
            }
        }
        return ans <= n ? ans : 0;
    }

    public static void main(String[] args) {
        int target = 15;
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new LeetCode209().minSubArrayLen(target, nums));
    }
}
