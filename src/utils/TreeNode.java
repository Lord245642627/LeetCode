package utils;

/**
 * @author Lord Camelot
 * @date 2023/12/4
 * @description
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {};
    public TreeNode(int val) {
        this.val =val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val =val;
        this.left = left;
        this.right = right;
    }

    public static void preorder(TreeNode node) {
        System.out.print(node.val);
        if (node.left != null) {
            System.out.print(",");
            preorder(node.left);
        }
        if (node.right != null) {
            System.out.print(",");
            preorder(node.right);
        }
    }
}
