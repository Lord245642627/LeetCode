package BreadthFirstSearch;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Lord Camelot
 * @date 2024/8/30
 * @description LeetCode1609 奇偶树
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 */
public class LeetCode1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int floor = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode pre = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (floor % 2 == 0) {
                    if (node.val % 2 == 0 || (pre != null && pre.val >= node.val)) {
                        return false;
                    }
                } else {
                    if (node.val % 2 != 0 || (pre != null && pre.val <= node.val)) {
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                pre = node;
            }
            floor++;
        }
        return true;
    }
}
