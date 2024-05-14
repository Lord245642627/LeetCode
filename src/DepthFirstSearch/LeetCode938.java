package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/14
 * @description LeetCode938 二叉搜索树的范围和
 */
public class LeetCode938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return dfs(root.left, low, high);
        }
        if (root.val < low) {
            return dfs(root.right, low, high);
        }
        return root.val + dfs(root.left, low, high) + dfs(root.right, low, high);
    }
}
