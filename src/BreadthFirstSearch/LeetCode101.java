package BreadthFirstSearch;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lord Camelot
 * @date 2024/3/20
 * @description LeetCode101 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return bfs(root);
//        return dfs(root.left, root.right);
    }

    private boolean bfs(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            leftQueue.offer(leftNode.left);
            leftQueue.offer(leftNode.right);
            rightQueue.offer(rightNode.right);
            rightQueue.offer(rightNode.left);
        }
        return true;
    }

    // 深度优先搜索的速度要快于广度优先搜索
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
