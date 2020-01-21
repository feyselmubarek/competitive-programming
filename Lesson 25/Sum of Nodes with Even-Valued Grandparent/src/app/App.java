package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int sumEvenGrandparent(TreeNode root) {
        return getEvenGrandSum(root.left, root) + getEvenGrandSum(root.right, root);
    }

    public int getEvenGrandSum(TreeNode node, TreeNode parent) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (parent.val % 2 == 0) {
            sum += node.left != null ? node.left.val : 0;
            sum += node.right != null ? node.right.val : 0;
        }

        if (node.left != null) {
            sum += getEvenGrandSum(node.left, node);
        }

        if (node.right != null) {
            sum += getEvenGrandSum(node.right, node);
        }

        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}