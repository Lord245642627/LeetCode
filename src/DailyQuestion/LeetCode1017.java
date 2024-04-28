package DailyQuestion;

/**
 * @author Lord Camelot
 * @date 2024/4/28
 * @description LeetCode1017 负二进制转换
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 */
public class LeetCode1017 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            sb.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1017().baseNeg2(3));
    }
}
