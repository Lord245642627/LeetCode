package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/11/22
 * @description LeetCode113 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, new ArrayList<Integer>(), targetSum);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, List<Integer> list, int targetSum) {
        targetSum -= node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList(list));
            }
        }
        if (node.left != null) {
            dfs(node.left, res, list, targetSum);
        }
        if (node.right != null) {
            dfs(node.right, res, list, targetSum);
        }
        list.remove(list.size() - 1);
    }
}
