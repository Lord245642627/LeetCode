package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/4
 * @description LeetCode91 解码方法
 */
public class LeetCode91 {
    public int numDecodings(String s) {
         int len = s.length();
         int[] dp = new int[len + 1];
         dp[0] = 1;
         for (int i = 1; i <= len; i++) {
             // 1. 单独解码：若当前位不为 0，则当前位必定可以单独解码，因此 dp[i] += dp[i - 1]
             if (s.charAt(i - 1) != '0') {
                 dp[i] += dp[i - 1];
             }
            // 2. 联合解码：若当前位不是第 1 位，且前一位不为 0，则判断最后两位的大小是否小于等于 26，若判断成立，则说明最后两位可一起解码，因此在前面的基础之上 dp[i] += dp[i - 2]
             if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                 dp[i] += dp[i - 2];
             }
         }
         return dp[len];
    }

    public static void main(String[] args) {
        String s = "06078";
        System.out.println(new LeetCode91().numDecodings(s));
    }
}
