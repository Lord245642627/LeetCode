package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/6
 * @description LeetCode375 猜数字大小 II
 * 我从 1 到 n 之间选择一个数字。
 * 你来猜我选了哪个数字。
 * 如果你猜到正确的数字，就会 赢得游戏 。
 * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
 * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
 * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
 */
public class LeetCode375 {
    public int getMoneyAmount(int n) {
        // dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1], dp[k + 1][j]) + k); i < k < j
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                // 当 j=n 时，如果 k=j 则 k+1>n，此时 f[k][j] 会出现下标越界。为了避免出现下标越界，计算 f[i][j] 的方法是：首先令 f[i][j]=j+f[i][j−1]，然后遍历 i≤k<j 的每个 k，更新 f[i][j] 的值。
                dp[i][j] = j + dp[i][j - 1];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                }
            }
        }
        return dp[1][n];
    }
}
