package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Lord Camelot
 * @date 2024/5/6
 * @description LeetCode987 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 */
public class LeetCode987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 采用有序 map，不需要针对 col 排序
        Map<Integer, List<int[]>> groups = new TreeMap<>();
        dfs(root, 0, 0, groups);
        List<List<Integer>> ans = new ArrayList<>(groups.size());
        for (List<int[]> list : groups.values()) {
            list.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> vals = new ArrayList<>(list.size());
            for (int[] l : list) {
                vals.add(l[1]);
            }
            ans.add(vals);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> groups) {
        if (node == null) {
            return;
        }
        groups.computeIfAbsent(col, key -> new ArrayList<>()).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, groups);
        dfs(node.right, row + 1, col + 1,groups);
    }
}
