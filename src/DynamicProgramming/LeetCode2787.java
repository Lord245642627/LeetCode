package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/2
 * @description LeetCode2787 将一个数字表示成幂的和的方案数
 * 给你两个 正 整数 n 和 x 。
 * 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1x + n2x + ... + nkx 。
 * 由于答案可能非常大，请你将它对 109 + 7 取余后返回。
 * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 23 + 33 + 53 。
 */
public class LeetCode2787 {
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int v = (int) Math.pow(i, x);
            for (int j = n; j >= v; j--) {
                dp[j] += dp[j - v];
            }
        }
        return (int) (dp[n] % 1_000_000_007);
    }
}
