package BreadthFirstSearch;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lord Camelot
 * @date 2024/8/30
 * @description LeetCode1302 层数最深叶子节点的和
 */
public class LeetCode1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ans = 0;
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                ans += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return ans;
    }
}
