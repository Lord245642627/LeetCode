package DepthFirstSearch;

import utils.TreeNode;

import java.util.Arrays;

/**
 * @author Lord Camelot
 * @date 2024/5/30
 * @description LeetCode889 根据前序和后序遍历构造二叉树
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * 如果存在多个答案，您可以返回其中 任何 一个。
 */
public class LeetCode889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return new TreeNode(preorder[0]);
        }
        int leftSize = indexOf(postorder, preorder[1]) + 1;
        int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 1, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);
    }

    private int indexOf(int[] postorder, int val) {
        for (int i = 0; ; i++) {
            if (postorder[i] == val) {
                return i;
            }
        }
    }
}
