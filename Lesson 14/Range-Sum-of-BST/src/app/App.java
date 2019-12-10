package app;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);

        treeNode.right.right = new TreeNode(18);
        // treeNode.right.left = new TreeNode(3);

        System.out.println(new Solution().rangeSumBST(new TreeNode(10), 7, 15));
    }
}