package DepthFirstSearch;

import utils.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2023/12/4
 * @description LeetCode95 不同的二叉搜索树 II
 */
public class LeetCode95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = dfs(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = dfs(i + 1, end);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = leftTree;
                    curTree.right = rightTree;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> res = new LeetCode95().generateTrees(n);
        System.out.print("[");
        for (TreeNode root : res) {
            System.out.print("[");
            TreeNode.preorder(root);
            System.out.print("]");
        }
        System.out.println("]");
    }
}
