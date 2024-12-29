package DynamicProgramming;

/**
 * @author lord
 * @date 2024/12/29
 * @description LeetCode2266 统计打字方案数
 * Alice 在给 Bob 用手机打字。数字到字母的对应
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 */
public class LeetCode2266 {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 100_001;
    private static final long[] f = new long[MAX];
    private static final long[] g = new long[MAX];

    static {
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        f[3] = 4;
        g[0] = 1;
        g[1] = 1;
        g[2] = 2;
        g[3] = 4;
        for (int i = 4; i < MAX; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
        }
    }

    public int countTexts(String pressedKeys) {
        long ans = 1;
        int cnt = 0;
        char[] charArray = pressedKeys.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            cnt++;
            if (i == charArray.length - 1 || charArray[i] != charArray[i + 1]) {
                ans = (ans * (charArray[i] != '7' && charArray[i] != '9' ? f[cnt] : g[cnt])) % MOD;
                cnt = 0;
            }
        }
        return (int) ans;
    }
}
