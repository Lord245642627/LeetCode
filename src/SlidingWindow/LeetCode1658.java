package SlidingWindow;

/**
 * @author Lord Camelot
 * @date 2024/4/3
 * @description LeetCode1658 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 */
public class LeetCode1658 {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        long sum = 0L;
        int maxLen = -1;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }
        for (int right = 0; right < nums.length; right++) {
            sum -= nums[right];
            while (sum < x) {
                sum += nums[left];
                left++;
            }
            if (sum == x) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen < 0 ? -1 : nums.length - maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        int x = 134365;
        System.out.println(new LeetCode1658().minOperations(nums, x));
    }
}
