package app;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.left != null) {
            sum += rangeSumBST(root.left, L, R);
        }

        if (root.right != null) {
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }
}