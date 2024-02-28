package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/2
 * @description LeetCode62 不同路径
 */
public class LeetCode62 {
    // 动态规划
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 组合数学
    public int uniquePaths2(int m, int n) {
        int ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return ans;
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(new LeetCode62().uniquePaths2(m, n));
    }
}
