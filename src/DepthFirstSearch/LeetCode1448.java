package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/6
 * @description LeetCode1448 统计二叉树中好节点的数目
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class LeetCode1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        if (node.val >= max) {
            return dfs(node.left, node.val) + dfs(node.right, node.val) + 1;
        }
        return dfs(node.left, max) + dfs(node.right, max);
    }
}
