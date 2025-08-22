package DynamicProgramming.TreeBasedDynamicProgramming;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2025/1/23
 * @description LeetCode124 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class LeetCode124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        ans = Math.max(ans, l + r + node.val);
        return Math.max(Math.max(l, r) + node.val, 0);
    }
}
