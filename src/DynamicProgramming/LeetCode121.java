package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2024/1/4
 * @description LeetCode121 买卖股票的最佳时机
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int curMin = prices[0];
        int max = 0;
        // 买的那天一定是卖的那天之前的最小值，因此维护一个当前的最低点
        for (int price : prices) {
            if (price < curMin) {
                curMin = price;
            } else {
                max = Math.max(max, price - curMin);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new LeetCode121().maxProfit(prices));
    }
}
