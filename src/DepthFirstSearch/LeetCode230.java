package DepthFirstSearch;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author Lord Camelot
 * @date 2024/5/15
 * @description LeetCode230 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class LeetCode230 {
    private int idx = 1;
    private int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
        // return loop(root, k);
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        if (idx == k) {
            ans = root.val;
        }
        idx += 1;
        dfs(root.right, k);
    }

    private int loop(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
