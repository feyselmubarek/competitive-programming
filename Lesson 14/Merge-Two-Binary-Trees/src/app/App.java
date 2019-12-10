package app;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(2);

        treeNode1.left.left = new TreeNode(5);
        // treeNode.left.right = new TreeNode(7);

        // treeNode.right.right = new TreeNode(18);
        // treeNode.right.left = new TreeNode(3);

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        // treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right.right = new TreeNode(7);
        // treeNode.right.left = new TreeNode(3);

        TreeNode n = new Solution().mergeTrees(treeNode1, treeNode);

        print(n);

    }

    public static void print(TreeNode n) {
        System.out.println(n.val + "=> node ");

        if (n.left != null) {
            print(n.left);
        }

        if (n.right != null) {
            print(n.right);
        }
    }
}