package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/11/29
 * @description LeetCode44 通配符匹配
 */
public class LeetCode44 {

    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            if (pArray[i - 1] == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (pArray[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pArray[j - 1] == '?' || sArray[i - 1] == pArray[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }



    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(new LeetCode44().isMatch(s, p));
    }
}
