package DepthFirstSearch;

import utils.TreeNode;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/5/30
 * @description LeetCode106 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        int leftSize = indexOf(inorder, postorder[n - 1]);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = buildTree(in1, post1);
        TreeNode right = buildTree(in2, post2);
        return new TreeNode(postorder[n - 1], left, right);
    }

    private int indexOf(int[] inorder, int val) {
        for (int i = 0; ; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
    }
}
