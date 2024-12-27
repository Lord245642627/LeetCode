package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lord
 * @date 2024/12/27
 * @description LeetCode51 N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        dfs(0, queens, col, diag1, diag2, res);
        return res;
    }

    private void dfs(int r, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> res) {
        int n = col.length;
        if (n == r) {
            res.add(createBoard(queens, n));
            return;
        }
        for (int c = 0; c < n; c++) {
            // 防止 r - c 小于 0
            int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) {
                queens[r] = c;
                col[c] = true;
                diag1[r + c] = true;
                diag2[rc] = true;
                dfs(r + 1, queens, col, diag1, diag2, res);
                col[c] = false;
                diag1[r + c] = false;
                diag2[rc] = false;
            }
        }
    }

    private List<String> createBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>(n);
        for (int q : queens) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[q] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        LeetCode51 solver = new LeetCode51();
        System.out.println(solver.solveNQueens(4));
    }
}
