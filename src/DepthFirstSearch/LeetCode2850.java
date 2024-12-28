package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/28
 * @description LeetCode2850 将石头分散到网格图的最少移动次数
 * 给你一个大小为 3 * 3 ，下标从 0 开始的二维整数矩阵 grid ，分别表示每一个格子里石头的数目。网格图中总共恰好有 9 个石头，一个格子里可能会有 多个 石头。
 * 每一次操作中，你可以将一个石头从它当前所在格子移动到一个至少有一条公共边的相邻格子。
 * 请你返回每个格子恰好有一个石头的 最少移动次数 。
 */
public class LeetCode2850 {
    public int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 1) {
                    for (int k = 1; k < grid[i][j]; k++) {
                        from.add(new int[]{i, j});
                    }
                } else if (grid[i][j] == 0) {
                    to.add(new int[]{i ,j});
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (List<int[]> fr : permutations(from)) {
            int total = 0;
            for (int i = 0; i < fr.size(); i++) {
                int[] f = fr.get(i);
                int[] t = to.get(i);
                total += Math.abs(f[0] - t[0]) + Math.abs(f[1] - t[1]);
            }
            res = Math.min(res, total);
        }
        return res;
    }

    private List<List<int[]>> permutations(List<int[]> arr) {
        List<List<int[]>> result = new ArrayList<>();
        dfs(result, arr, 0);
        return result;
    }

    private void dfs(List<List<int[]>> result, List<int[]> arr, int index) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            swap(arr, index, i);
            dfs(result, arr, index + 1);
            swap(arr, index, i);
        }
    }

    private void swap(List<int[]> arr, int i, int j) {
        int[] temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
