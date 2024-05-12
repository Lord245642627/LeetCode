package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/12
 * @description LeetCode1026 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 */
public class LeetCode1026 {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }
}
