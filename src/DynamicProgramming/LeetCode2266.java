package DynamicProgramming;

/**
 * @author lord
 * @date 2024/12/29
 * @description LeetCode2266 统计打字方案数
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
