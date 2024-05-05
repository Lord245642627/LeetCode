package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/5/6
 * @description LeetCode257 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            ans.add(new String(sb.toString()));
            return ans;
        }
        dfs(root.left, new StringBuilder(sb.toString()), ans);
        dfs(root.right, sb, ans);
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb, List<String> ans) {
        if (node == null) {
            return;
        }
        sb.append("->").append(node.val);
        if (node.left == null && node.right == null) {
            ans.add(new String(sb.toString()));
        }
        dfs(node.left, new StringBuilder(sb.toString()), ans);
        dfs(node.right, new StringBuilder(sb.toString()), ans);
    }
}
