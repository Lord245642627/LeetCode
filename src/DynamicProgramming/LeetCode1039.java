package DynamicProgramming;

/**
 * @author lord
 * @date 2025/1/6
 * @description LeetCode1039 多边形三角剖分的最低得分
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 */
public class LeetCode1039 {
    public int minScoreTriangulation(int[] values) {
        // 设 dp[i][j] 表示沿着边从定点 i 顺时针到顶点 j，再加上直接从 j 到 i 的这条边所组成的多边形的最低得分
        // dp[i][j] = Math.min(dp[i][k] + dp[k][j] + v[i] * v[k] * v[j]);  i < k < j
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
