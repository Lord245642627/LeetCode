package DepthFirstSearch;

/**
 * @author lord
 * @date 2024/11/22
 * @description LeetCode2397 被列覆盖的最多行数
 * 给你一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix ；另给你一个整数 numSelect，表示你必须从 matrix 中选择的 不同 列的数量。
 * 形式上，假设 s = {c1, c2, ...., cnumSelect} 是你选择的列的集合。对于矩阵中的某一行 row ，如果满足下述条件，则认为这一行被集合 s 覆盖：
 * 对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col]（0 <= col <= n - 1），col 均存在于 s 中，或者
 * row 中 不存在 值为 1 的单元格。
 * 你需要从矩阵中选出 numSelect 个列，使集合覆盖的行数最大化。
 * 返回一个整数，表示可以由 numSelect 列构成的集合 覆盖 的 最大行数 。
 */
public class LeetCode2397 {
    int res = 0;
    public int maximumRows(int[][] matrix, int numSelect) {
        dfs(matrix, numSelect, 0);
        return res;
    }

    private void dfs(int[][] matrix, int numSelect, int index) {
        if (index == matrix[0].length) {
            int count = getRow(matrix);
            res = Math.max(res, count);
            return;
        }
        dfs(matrix, numSelect, index + 1);
        if (numSelect > 0) {
            numSelect--;
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][index] -= 1;
            }
            dfs(matrix, numSelect, index + 1);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][index] += 1;
            }
        }
    }

    private int getRow(int[][] matrix) {
        int count = 0, flag = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    flag = 0;
                    break;
                }
            }
            count += flag;
            flag = 1;
        }
        return count;
    }
}
