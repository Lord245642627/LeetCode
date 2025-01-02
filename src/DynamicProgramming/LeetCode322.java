package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lord
 * @date 2025/1/2
 * @description LeetCode322 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount +1];
        // 为了避免溢出，这里需要除以 2
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}
