package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/12
 * @description LeetCode1372 二叉树中的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 */
public class LeetCode1372 {
    int maxAns;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAns = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxAns;
    }

    private void dfs(TreeNode root, boolean flag, int len) {
        maxAns = Math.max(len, maxAns);
        if (flag) {
            if (root.left != null) {
                dfs(root.left, true, 1);
            }
            if (root.right != null) {
                dfs(root.right, false, len + 1);
            }
        } else {
            if (root.left != null) {
                dfs(root.left, true, len + 1);
            }
            if (root.right != null) {
                dfs(root.right, false, 1);
            }
        }
    }
}
