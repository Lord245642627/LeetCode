package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/6
 * @description LeetCode115 不同的子序列
 */
public class LeetCode115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        // 空字符串是任何字符串的子序列，非空字符串不是空字符串的子序列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i && j <= n; j++) {
                dp[i][j] += dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(new LeetCode115().numDistinct(s, t));
    }
}
