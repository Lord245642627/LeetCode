package SlidingWindow;

/**
 * @author Lord Camelot
 * @date 2024/4/1
 * @description LeetCode2962 统计最大元素出现至少 K 次的子数组
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * 子数组是数组中的一个连续元素序列。
 */
public class LeetCode2962 {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int count = 0;
        long ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }
            while (count == k) {
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
            // 重点：对于右端点为 right 且左端点小于 left 的子数组，max 的出现次数都至少为 k，把答案增加 left
            ans += left;
        }
        return ans;
    }
}
