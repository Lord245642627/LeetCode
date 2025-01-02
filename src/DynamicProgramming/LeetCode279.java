package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lord
 * @date 2025/1/2
 * @description LeetCode279 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int t = i * i;
            for (int j = t; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - t] + 1);
            }
        }
        return dp[n];
    }
}
