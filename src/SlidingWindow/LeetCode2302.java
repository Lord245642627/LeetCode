package SlidingWindow;

/**
 * @author Lord Camelot
 * @date 2024/4/2
 * @description LeetCode2302 统计得分小于 K 的子数组数目
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * 子数组 是数组中的一个连续元素序列。
 */
public class LeetCode2302 {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0L, sum = 0L;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            // 本题元素均为正数，这意味着只要某个子数组满足题目要求，在该子数组内的更短的子数组同样也满足题目要求。
            ans += right - left + 1;
        }
        return ans;
    }
}
