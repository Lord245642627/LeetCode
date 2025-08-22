package DynamicProgramming.TreeBasedDynamicProgramming;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2025/1/24
 * @description LeetCode687 最长同值路径
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度 由它们之间的边数表示。
 */
public class LeetCode687 {
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int l = dfs(node.left) + 1;
        int r = dfs(node.right) + 1;
        if (node.left != null && node.left.val != node.val) {
            l = 0;
        }
        if (node.right != null && node.right.val != node.val) {
            r = 0;
        }
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}
