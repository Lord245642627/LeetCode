package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Lord Camelot
 * @date 2024/5/30
 * @description LeetCode1110 删点成林
 */
public class LeetCode1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int delete : to_delete) {
            set.add(delete);
        }
        if (dfs(root, set, ans) != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> ans) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left, set, ans);
        node.right = dfs(node.right, set, ans);
        if (!set.contains(node.val)) {
            return node;
        }
        if (node.left != null) {
            ans.add(node.left);
        }
        if (node.right != null) {
            ans.add(node.right);
        }
        return null;
    }
}
