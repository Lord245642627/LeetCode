package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/7
 * @description LeetCode110 平衡二叉树
 * 给定一个二叉树，判断它是否是平衡二叉树
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
