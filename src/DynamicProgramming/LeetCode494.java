package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/2
 * @description LeetCode494 目标和
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        // 设 nums 中的和为 s, target 为 t
        // 设正数的和为 p
        // 则负数的和的绝对值为 s - p
        // 所以有 p - (s - p) = t
        // 化简得 2p = t + s
        // p = (t + s) / 2;
        // 即原问题等价于：从 nums 中取出和为 (t + s) / 2 的数
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        target += sum;
        if (target % 2 != 0 || target < 0) {
            return 0;
        }
        target /= 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (nums[i] <= j) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
