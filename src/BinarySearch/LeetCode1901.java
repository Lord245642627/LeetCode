package BinarySearch;

/**
 * @author Lord Camelot
 * @date 2024/4/30
 * @description LeetCode1901 寻找峰值 II
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 */
public class LeetCode1901 {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0, right = mat.length - 2;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = indexOfMax(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return new int[]{left, indexOfMax(mat[left])};
    }

    private int indexOfMax(int[] list) {
        int idx = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[idx] < list[i]) {
                idx = i;
            }
        }
        return idx;
    }
}
