package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2024/1/4
 * @description LeetCode122 买卖股票的最佳时机 II
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        // dp[0] 表示第 i 天结束时不持有股票情况下的最大利润
        // dp[1] 表示第 i 天结束时持有股票情况下的最大利润
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = Math.max(dp[0], dp[1] + price);
            dp[1] = Math.max(dp[1], dp[0] - price);
            dp[0] = temp;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new LeetCode122().maxProfit(prices));
    }
}
