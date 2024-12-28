package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord
 * @date 2024/11/21
 * @description LeetCode257 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode node, List<String> res, List<Integer> list) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(transferListToStr(list));
        } else {
            if (node.left != null) {
                dfs(node.left, res, list);
            }
            if (node.right != null) {
                dfs(node.right, res, list);
            }
        }
        list.remove(list.size() - 1);
    }

    private String transferListToStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(Integer.toString(list.get(i)));
            if (i < size - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(new LeetCode257().binaryTreePaths(root));
    }
}
