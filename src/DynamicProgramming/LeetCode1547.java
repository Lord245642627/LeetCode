package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lord
 * @date 2025/1/8
 * @description LeetCode1547 切棍子的最小成本
 * 有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
 * 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
 * 你可以按顺序完成切割，也可以根据需要更改切割的顺序。
 * 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。请参阅第一个示例以获得更直观的解释。
 * 返回切棍子的 最小总成本 。
 */
public class LeetCode1547 {
    public int minCost(int n, int[] cuts) {
        // dp[i][j] = Math.min(dp[i][k] + dp[k][j] + cur)
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        for (int i = 1; i <= m; i++) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[m + 1] = n;
        // 因为需要用到 i - 1 和 j + 1，所以这里空间在原有基础上 +2（前后各 +1 避免溢出）
        int[][] dp = new int[m + 2][m + 2];
        for (int i = m; i >= 1; i--) {
            // dp[i][i] = n;
            for (int j = i; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                }
                dp[i][j] += newCuts[j + 1] - newCuts[i - 1];
            }

        }
        return dp[1][m];
    }

    public static void main(String[] args) {
        LeetCode1547 leetCode = new LeetCode1547();
        System.out.println(leetCode.minCost(9, new int[]{2, 1}));
    }
}
