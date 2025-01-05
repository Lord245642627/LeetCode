package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/5
 * @description LeetCode188 买卖股票的最佳时机 IV
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[i][1] = Integer.MIN_VALUE / 2;
        }
        for(int price : prices) {
            for (int i = k; i > 0; i--) {
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + price);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - price);
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
        LeetCode188 leetcode = new LeetCode188();
        System.out.println(leetcode.maxProfit(2, new int[]{2, 4, 1}));
    }
}
