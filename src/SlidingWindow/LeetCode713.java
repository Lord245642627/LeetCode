package SlidingWindow;

/**
 * @author Lord Camelot
 * @date 2024/3/25
 * @description LeetCode713 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 */
public class LeetCode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int ans = 0;
        int cur = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            cur *= nums[right];
            while (cur >= k) {
                cur /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new LeetCode713().numSubarrayProductLessThanK(nums, k));
    }

}
