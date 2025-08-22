package DynamicProgramming.TreeBasedDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2025/1/24
 * @description LeetCode3203 合并两棵树后的最小直径
 * 给你两棵 无向 树，分别有 n 和 m 个节点，节点编号分别为 0 到 n - 1 和 0 到 m - 1 。给你两个二维整数数组 edges1 和 edges2 ，长度分别为 n - 1 和 m - 1 ，其中 edges1[i] = [ai, bi] 表示在第一棵树中节点 ai 和 bi 之间有一条边，edges2[i] = [ui, vi] 表示在第二棵树中节点 ui 和 vi 之间有一条边。
 * 你必须在第一棵树和第二棵树中分别选一个节点，并用一条边连接它们。
 * 请你返回添加边后得到的树中，最小直径 为多少。
 * 一棵树的 直径 指的是树中任意两个节点之间的最长路径长度。
 */
public class LeetCode3203 {
    private int res;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = diameter(edges1);
        int d2 = diameter(edges2);
        return Math.max(Math.max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }

    private int diameter(int[][] edges) {
        List<Integer>[] g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        res = 0;
        dfs(0, -1, g);
        return res;
    }

    private int dfs(int x, int fa, List<Integer>[] g) {
        int maxLen = 0;
        for (int y : g[x]) {
            if (y != fa) {
                int subLen = dfs(y, x, g) + 1;
                res = Math.max(res, maxLen + subLen);
                maxLen = Math.max(maxLen, subLen);
            }
        }
        return maxLen;
    }
}
