package DynamicProgramming.TreeBasedDynamicProgramming;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2025/1/23
 * @description LeetCode543  二叉树的直径
 * 树形 DP
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class LeetCode543 {
    int ans = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int l = dfs(node.left) + 1;
        int r = dfs(node.right) + 1;
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}
