package BreadthFirstSearch;

/**
 * @author lord
 * @date 2024/12/27
 * @description LeetCode52 N 皇后 II
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 */
public class LeetCode52 {
    private int res = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        dfs(0, col, diag1, diag2);
        return res;
    }

    private void dfs(int r, boolean[] col, boolean[] diag1, boolean[] diag2) {
        int n = col.length;
        if (r == n) {
            res++;
            return;
        }
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) {
                col[c] = true;
                diag1[r + c] = true;
                diag2[rc] = true;
                dfs(r + 1, col, diag1, diag2);
                col[c] = false;
                diag1[r + c] = false;
                diag2[rc] = false;
            }
        }
    }
}
