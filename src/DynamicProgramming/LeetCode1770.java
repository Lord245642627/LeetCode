package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lord
 * @date 2025/1/7
 * @description LeetCode1770 执行乘法运算的最大分数
 * 给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
 * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
 * 选择数组 nums 开头处或者末尾处 的整数 x 。
 * 你获得 multipliers[i] * x 分，并累加到你的分数中。
 * 将 x 从数组 nums 中移除。
 * 在执行 m 步操作后，返回 最大 分数。
 */
public class LeetCode1770 {
    public int maximumScore(int[] nums, int[] multipliers) {
        // dp[i][j] 表示前面取出 i 个元素，后面取出 j 个元素
        int m = nums.length, n = multipliers.length;
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = i + j;
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + nums[i - 1] * multipliers[k - 1]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + nums[m - j] * multipliers[k - 1]);
                }
                if (k == n) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
