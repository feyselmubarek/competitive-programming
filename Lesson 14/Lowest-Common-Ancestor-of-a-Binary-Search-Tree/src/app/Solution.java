package app;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode leftNode = null, rightNode = null;
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if (root.left != null) {
            leftNode = lowestCommonAncestor(root.left, p, q);
        }

        if (root.right != null) {
            rightNode = lowestCommonAncestor(root.right, p, q);
        }

        if (leftNode != null && rightNode != null) {
            return root;
        }

        if (leftNode != null) {
            return leftNode;
        }

        return rightNode;
    }
}