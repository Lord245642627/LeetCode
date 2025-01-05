package GreedyAlgorithm;

/**
 * @author Lord Camelot
 * @date 2024/1/4
 * @description LeetCode122 买卖股票的最佳时机 II
 */
public class LeetCode122 {
    // 由于卖出的当天还可以买入，因此只要今天比昨天的价格高就卖出
    public int maxProfit(int[] prices) {
        int res = 0;
        int pre = prices[0];
        for (int price : prices) {
            if (price > pre) {
                res += price - pre;
            }
            pre = price;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new LeetCode122().maxProfit(prices));
    }
}
