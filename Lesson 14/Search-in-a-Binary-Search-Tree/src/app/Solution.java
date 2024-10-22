package app;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = null, rightNode = null;

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.left != null && root.val >= val) {
            node = searchBST(root.left, val);
        }

        if (root.right != null && root.val <= val) {
            rightNode = searchBST(root.right, val);
        }

        if (node != null) {
            return node;
        }

        return rightNode;
    }
}