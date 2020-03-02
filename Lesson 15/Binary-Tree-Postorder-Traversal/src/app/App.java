package app;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);

        // treeNode.left.left = new TreeNode(1);
        // treeNode.left.right = new TreeNode(2);

        // treeNode.right.right = new TreeNode(16);
        // treeNode.right.left = new TreeNode(5);

        List<Integer> n = new Solution().postorderTraversal(treeNode);

        for (Integer integer : n) {
            System.out.print(integer + ", ");
        }
        System.out.println();

    }
}