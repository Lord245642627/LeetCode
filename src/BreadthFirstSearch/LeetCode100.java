package BreadthFirstSearch;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lord Camelot
 * @date 2024/3/20
 * @description LeetCode100 相同的树。
 * 给两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return bfs(p, q);
//        return dfs(p, q);
    }

    // 广度优先算法一般采用队列
    private boolean bfs(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode pNode = queue1.poll();
            TreeNode qNode = queue2.poll();
            if (pNode == null && qNode == null) {
            } else if (pNode != null && qNode != null) {
                if (pNode.val != qNode.val) {
                    return false;
                } else {
                    queue1.offer(pNode.left);
                    queue1.offer(pNode.right);
                    queue2.offer(qNode.left);
                    queue2.offer(qNode.right);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // 深度优先算法采用递归比较简单
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && dfs(p.left, q.left) && dfs(p.right, q.right);
        } else {
            return false;
        }
    }
}
