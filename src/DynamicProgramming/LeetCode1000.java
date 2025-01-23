package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2025/1/23
 * @description LeetCode1000 合并石头的最低成本
 * 有 n 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * 每次 移动 需要将 连续的 k 堆石头合并为一堆，而这次移动的成本为这 k 堆中石头的总数。
 * 返回把所有石头合并成一堆的最低成本。如果无法合并成一堆，返回 -1 。
 */
public class LeetCode1000 {
    // TODO 理解
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) {
            return -1;
        }

        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i];
        }

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += s[j + 1] - s[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
