package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2025/1/5
 * @description LeetCode309 买卖股票的最佳时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        // 因为第 i 天买股票的话第 i−1 天不能卖，只能从第 i−2 天没有股票的状态转移过来
        int pre = 0;
        dp[0] = 0;
        dp[1] = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = Math.max(dp[1] + price, dp[0]);
            dp[1] = Math.max(pre - price, dp[1]);
            pre = dp[0];
            dp[0] = temp;
        }
        return dp[0];
    }
}
