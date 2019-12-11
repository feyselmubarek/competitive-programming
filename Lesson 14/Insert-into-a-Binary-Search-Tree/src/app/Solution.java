package app;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode leftNode = null, rightNode = null;

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val >= val && root != null) {
            leftNode = insertIntoBST(root.left, val);
        }

        if (root.val <= val && root != null) {
            rightNode = insertIntoBST(root.right, val);
        }

        if (leftNode != null) {
            root.left = leftNode;
        }

        if (rightNode != null) {
            root.right = rightNode;
        }

        return root;
    }
}