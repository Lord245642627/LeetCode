package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/3
 * @description LeetCode712 两个字符串的最小ASCII删除和
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 */
public class LeetCode712 {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] += dp[0][i - 1] + s2.charAt(i - 1);
        }
        for (int i = 1; i <= len1; i++) {
            int code1 = s1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                int code2 = s2.charAt(j - 1);
                if (code1 == code2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] +code1, dp[i][j - 1] + code2);
                }
            }
        }
        return dp[len1][len2];
    }
}
