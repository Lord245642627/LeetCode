package DynamicProgramming;

/**
 * @author lord
 * @date 2023/10/17
 * @description LeetCode32 最长有效括号
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (charArray[i] == ')') {
                if (charArray[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && charArray[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new LeetCode32().longestValidParentheses(s));
    }
}
