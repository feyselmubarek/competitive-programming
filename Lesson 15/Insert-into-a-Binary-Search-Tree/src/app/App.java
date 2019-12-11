package app;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);

        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);

        treeNode.right.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(5);

        TreeNode n = new Solution().insertIntoBST(treeNode, 6);

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