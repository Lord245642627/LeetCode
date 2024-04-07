package BinarySearch;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/4/7
 * @description 统计公平数对的数目
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 */
public class LeetCode2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int r = lowerBound(nums, i, upper - nums[i] + 1);
            int l = lowerBound(nums, i,  lower - nums[i]);
            ans += r - l;
        }
        return ans;
    }

    private int lowerBound(int[] nums, int right, int target) {
        int left = 0;
        right = right - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
