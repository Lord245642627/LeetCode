package DepthFirstSearch;

import utils.TreeNode;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/5/30
 * @description LeetCode105 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        int leftSize = indexOf(inorder, preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 1, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);

    }

    private int indexOf(int[] inorder, int val) {
        for (int i = 0; ; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
    }
}
