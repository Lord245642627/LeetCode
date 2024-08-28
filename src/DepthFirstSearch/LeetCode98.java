package DepthFirstSearch;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Lord Camelot
 * @date 2024/3/19
 * @description
 */
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return preorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        return inorder(root);
    }

    // 方法一：先序遍历-递归（如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树）
    private boolean preorder(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return preorder(node.left, lower, node.val) && preorder(node.right, node.val, upper);
    }

    // 方法二：中序遍历-循环（二叉搜索树的中序遍历一定为顺序）
    private boolean inorder(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while(!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= inorder) {
                return false;
            }
            inorder = node.val;
            node = node.right;
        }
        return true;
    }

    private long pre = Long.MIN_VALUE;
    private boolean inorder2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder2(root.left) || root.val <= pre) {
            return false;
        }
        pre = root.val;
        return inorder2(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(new LeetCode98().inorder2(root));
    }
}
