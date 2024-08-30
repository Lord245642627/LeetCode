package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lord Camelot
 * @date 2024/8/30
 * @description LeetCode117 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 */
public class LeetCode117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> ans = List.of(root);
        while (!ans.isEmpty()) {
            List<Node> tmp = ans;
            ans = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                Node node = tmp.get(i);
                if (i > 0) {
                    tmp.get(i - 1).next = node;
                }
                if (node.left != null) {
                    ans.add(node.left);
                }
                if (node.right != null) {
                    ans.add(node.right);
                }
            }
        }
        return root;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
