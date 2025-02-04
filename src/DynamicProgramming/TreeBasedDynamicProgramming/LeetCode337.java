package DynamicProgramming.TreeBasedDynamicProgramming;

import utils.TreeNode;

/**
 * @author Lord Camelot
 * @date 2025/2/4
 * @description LeetCode337 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class LeetCode337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int rob = left[1] + right[1] + node.val;
        int noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, noRob};
    }
}
