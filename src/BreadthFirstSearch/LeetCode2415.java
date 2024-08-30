package BreadthFirstSearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/8/30
 * @description LeetCode2415 反转二叉树的奇数层
 * 给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
 * 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
 * 反转后，返回树的根节点。
 * 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
 * 节点的 层数 等于该节点到根节点之间的边数。
 */
public class LeetCode2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        List<TreeNode> list = List.of(root);
        int floor = 0;
        while (!list.isEmpty()) {
            List<TreeNode> tmp = list;
            list = new ArrayList<>();
            int size = tmp.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tmp.get(i);
                if (floor % 2 != 0 && i < size / 2) {
                    int t = node.val;
                    node.val = tmp.get(size - i - 1).val;
                    tmp.get(size - i - 1).val = t;
                }
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            floor++;
        }
        return root;
    }
}
