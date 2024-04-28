package BinarySearch;

/**
 * @author Lord Camelot
 * @date 2024/4/28
 * @description LeetCode2439 最小化数组中的最大值
 * 给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。
 * 每一步操作中，你需要：
 * 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。
 * 将 nums[i] 减 1 。
 * 将 nums[i - 1] 加 1 。
 * 你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。
 */
public class LeetCode2439 {
    public int minimizeArrayValue(int[] nums) {
        int left = 0, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int limit) {
        long temp = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            temp = Math.max(nums[i] + temp - limit, 0);
        }
        return nums[0] + temp <= limit;
    }
}
