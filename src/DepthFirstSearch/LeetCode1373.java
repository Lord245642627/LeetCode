package DepthFirstSearch;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2024/5/28
 * @description LeetCode1373 二叉搜索子树的最大键值和
 */
public class LeetCode1373 {
    private int ans;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 通过记录每棵子树的最大值和最小值，减少计算量
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (root.val <= left[1] || root.val >= right[0]) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int sum = left[2] + right[2] + root.val;
        ans = Math.max(ans, sum);
        return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), sum};
    }
}
