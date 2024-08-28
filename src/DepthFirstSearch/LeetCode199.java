package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Lord Camelot
 * @date 2024/8/28
 * @description
 */
public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
        // return bfs(root);
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }

    private List<Integer> bfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
}
