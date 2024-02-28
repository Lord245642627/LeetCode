package DynamicProgramming;

/**
 * @author lord
 * @date 2023/10/17
 * @description LeetCode5. 最长回文子串
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int len = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        for (int col = 0; col < s.length(); col++) {
            for (int row = 0; row <= col; row++) {
                if (charArray[col] == charArray[row]) {
                    if (row == col || row + 1 == col) {
                        dp[row][col] = true;
                    } else {
                        dp[row][col] = dp[row + 1][col - 1];
                    }
                    if (dp[row][col] && col - row + 1 > len) {
                        len = col - row + 1;
                        start = row;
                    }
                }
            }
        }
        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(new LeetCode5().longestPalindrome(s));
    }
}
