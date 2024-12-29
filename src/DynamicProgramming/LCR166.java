package DynamicProgramming;

/**
 * @author lord
 * @date 2024/12/29
 * @description LCR166 珠宝的最高价值
 * 现有一个记作二维矩阵 frame 的珠宝架，其中 frame[i][j] 为该位置珠宝的价值。拿取珠宝的规则为：
 * 只能从架子的左上角开始拿珠宝
 * 每次可以移动到右侧或下侧的相邻位置
 * 到达珠宝架子的右下角时，停止拿取
 * 注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 frame = [[0]]。
 */
public class LCR166 {
    public int jewelleryValue(int[][] frame) {
        int row = frame.length;
        if (row == 0) {
            return 0;
        }
        int col = frame[0].length;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            dp[0] += frame[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + frame[i][j];
            }
        }
        return dp[col - 1];
    }
}
