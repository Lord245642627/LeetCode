package DailyQuestion;

/**
 * @author lord
 * @date 2025/8/22
 * @description LeetCode3195 包含所有 1 的最小矩形面积 I
 * 给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
 * 返回这个矩形可能的 最小 面积。
 */
public class LeetCode3195 {
    public int minimumArea(int[][] grid) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        int top = Integer.MAX_VALUE;
        int bottom = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        return (right - left + 1) * (bottom - top + 1);
    }
}
