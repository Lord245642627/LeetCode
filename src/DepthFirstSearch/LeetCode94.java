package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/3/19
 * @description LeetCode94 二叉树的中序遍历
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            dfs(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            dfs(node.right, list);
        }
    }
}
