package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/2/28
 * @description LeetCode131 分割回文串
 */
public class LeetCode131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        // 首先通过动态规划进行预处理，得到字符串的回文动态规划矩阵
        boolean[][] dp = isPalindrome(s);
        // 然后通过回溯法对动态规划矩阵进行回溯搜索，取到所有可能的情况
        backtrack(0, s, new ArrayList<>(), res, dp);
        return res;
    }

    public boolean[][] isPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] c = s.toCharArray();

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (c[i] == c[j]) {
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

    public void backtrack(int k, String s, List<String> list, List<List<String>> res, boolean[][] dp) {
        int n = s.length();
        if (k == n) {
            res.add(new ArrayList<>(list));
        }
        for (int i = k; i < n; i++) {
            if (dp[k][i]) {
                list.add(s.substring(k, i + 1));
                backtrack(i + 1, s, list, res, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new LeetCode131().partition(s));
    }
}
