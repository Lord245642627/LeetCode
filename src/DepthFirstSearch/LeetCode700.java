package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/14
 * @description LeetCode700 二叉搜索树中的搜索
 */
public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return dfs(root.left, val);
        }
        if (root.val < val) {
            return dfs(root.right, val);
        }
        return null;
    }
}
