package DynamicProgramming;

/**
 * @author lord
 * @date 2024/12/27
 * @description LeetCode746 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        int p = 0, q = 0;
        int temp = 0;
        for (int i = 0; i < cost.length; i++) {
            temp = Math.min(p, q) + cost[i];
            p = q;
            q = temp;
        }
        return Math.min(p, q);
    }
}
