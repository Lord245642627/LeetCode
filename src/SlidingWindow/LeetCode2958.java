package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lord Camelot
 * @date 2024/3/28
 * @description LeetCode2958 最多 K 个重复元素的最长子数组
 * 给你一个整数数组 nums 和一个整数 k 。一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。请你返回 nums 中 最长好 子数组的长度。子数组 指的是一个数组中一段连续非空的元素序列。
 */
public class LeetCode2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        if (nums.length <= k) {
            return k;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (map.get(nums[right]) == null) {
                map.put(nums[right], 0);
            } else if (map.get(nums[right]) < k) {
                map.put(nums[right], map.get(nums[right]) + 1);
            } else {
                while (map.get(nums[right]) == k) {
                    left++;
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
