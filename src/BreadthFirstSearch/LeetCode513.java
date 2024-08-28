package BreadthFirstSearch;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lord Camelot
 * @date 2024/8/28
 * @description LeetCode513 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 */
public class LeetCode513 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

            }
        }
        return node.val;
    }
}
