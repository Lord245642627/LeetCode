package DynamicProgramming;

/**
 * @author Lord Camelot
 * @date 2023/12/4
 * @description LeetCode85 最大矩形
 */
public class LeetCode85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0 ? 1 : dp[i][j - 1] + 1);
                    int width = dp[i][j];
                    int area = width;
                    for (int k = i - 1; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        area = Math.max(area, width * (i - k + 1));
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new LeetCode85().maximalRectangle(matrix));
    }
}
