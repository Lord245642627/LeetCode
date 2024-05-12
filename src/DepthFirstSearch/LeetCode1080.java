package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/12
 * @description LeetCode1080 根到叶路径上的不足节点
 * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
 * 叶子节点，就是没有子节点的节点。
 */
public class LeetCode1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if (root.left == null && root.right == null) {
            // 如果 limit > 0 说明从根到叶子的路径和小于 limit，删除叶子，否则不删除
            return limit > 0 ? null : root;
        }
        if (root.left != null) {
            root.left = sufficientSubset(root.left, limit);
        }
        if (root.right != null) {
            root.right = sufficientSubset(root.right, limit);
        }
        // 如果儿子都被删除，就删 root，否则不删 root
        return root.left == null && root.right == null ? null : root;
    }
}
