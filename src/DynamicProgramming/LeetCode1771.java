package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/7
 * @description LeetCode1771 由子序列构造的最长回文串的长度
 * 给你两个字符串 word1 和 word2 ，请你按下述方法构造一个字符串：
 * 从 word1 中选出某个 非空 子序列 subsequence1 。
 * 从 word2 中选出某个 非空 子序列 subsequence2 。
 * 连接两个子序列 subsequence1 + subsequence2 ，得到字符串。
 * 返回可按上述方法构造的最长 回文串 的 长度 。如果无法构造回文串，返回 0 。
 * 字符串 s 的一个 子序列 是通过从 s 中删除一些（也可能不删除）字符而不更改其余字符的顺序生成的字符串。
 * 回文串 是正着读和反着读结果一致的字符串。
 */
public class LeetCode1771 {
    public int longestPalindrome(String word1, String word2) {
        char[] s = (word1 + word2).toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < word1.length() && j >= word1.length()) {
                        res = Math.max(res, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return res;
    }
}
