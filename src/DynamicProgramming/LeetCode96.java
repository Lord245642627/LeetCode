package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/4
 * @description LeetCode96 不同的二叉搜索树
 */
public class LeetCode96 {
    // 动态规划
    public int numTrees1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    // 数学
    public int numTrees(int n) {
        // 这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new LeetCode96().numTrees1(n));
    }
}
