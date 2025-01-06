package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/6
 * @description LeetCode516 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LeetCode516 {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j] = dp[i + 1][j - 1] + 2; s.charAt(i) == s.charAt(j)
        // dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]); s.charAt(i) != s.charAt(j)
        char[] charArray = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int tmp = dp[j];
                dp[j] = charArray[i] == charArray[j] ? pre + 2 : Math.max(dp[j], dp[j - 1]);
                pre = tmp;
            }
        }
        return dp[n - 1];
    }
}
