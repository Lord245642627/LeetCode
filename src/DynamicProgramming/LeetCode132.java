package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/2/29
 * @description LeetCode132 分割回文串II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的 最少分割次数 。
 */
public class LeetCode132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        // f[i] = min(f[j]) + 1,其中 s[j + 1..i] 是一个回文串
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (f[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (f[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
                dp[i]++;
            }
        }
        return dp[n - 1];
    }


    public int minCut1(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        boolean[][] dp = isPalindrome(str);

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }

    public boolean[][] isPalindrome(char[] str) {
        int n = str.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (str[i] == str[j]) {
                    if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp;
    }

    // 超时
    public int dfs(boolean[][] dp, int index) {
        if (index == dp.length) {
            return 0;
        }
        int min = dp.length;
        for (int i = index; i < dp.length; i++) {
            if (dp[index][i]) {
                min = Math.min(min, dfs(dp,i + 1));
            }
        }
        return min + 1;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new LeetCode132().minCut(s));
    }
}
