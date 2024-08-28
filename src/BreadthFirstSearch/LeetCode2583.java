package BreadthFirstSearch;

import utils.TreeNode;

import java.util.*;

/**
 * @author Lord Camelot
 * @date 2024/8/28
 * @description LeetCode2583 二叉树中的第 K 大层和
 * 给你一棵二叉树的根节点 root 和一个正整数 k 。
 * 树中的 层和 是指 同一层 上节点值的总和。
 * 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。
 * 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。
 */
public class LeetCode2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0L;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(sum);
        }
        int n = ans.size();
        if (k > n) {
            return -1;
        }
        Collections.sort(ans);
        return ans.get(n - k);
    }
}
