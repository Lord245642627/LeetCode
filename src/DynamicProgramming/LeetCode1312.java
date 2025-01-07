package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/7
 * @description LeetCode1312 让字符串成为回文串的最少插入次数
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * 「回文串」是正读和反读都相同的字符串。
 */
public class LeetCode1312 {
    public int minInsertions(String s) {
        // 如果 s[i] == s[j]，那么最外层已经形成了回文，只需要继续考虑 s[i+1:j-1]；
        // 如果 s[i] != s[j]，那么要么在 s[i:j] 的末尾添加字符 s[i]，要么在 s[i:j] 的开头添加字符 s[j]。如果选择前者，那么需要继续考虑 s[i+1:j]；如果选择后者，那么需要继续考虑 s[i:j-1]。
        // dp[i][j] = min(dp[i + 1][j], dp[i][j - 1]) + 1       if s[i] != s[j]
        // dp[i][j] = dp[i + 1][j - 1]                          if s[i] == s[j]
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
