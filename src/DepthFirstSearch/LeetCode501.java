package DepthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/5/15
 * @description LeetCode501 二叉搜索树中的众数
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 */
public class LeetCode501 {
    private List<Integer> ans = new ArrayList<Integer>();
    private int base = 0;
    private int count = 0;
    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            mode[i] = ans.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int x) {
        if (x == base) {
            count++;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            ans.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(base);
        }
    }
}
