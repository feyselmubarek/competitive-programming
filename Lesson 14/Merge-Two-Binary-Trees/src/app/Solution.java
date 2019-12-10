package app;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;

        if (t1 != null && t2 == null) {
            root = new TreeNode(t1.val);
        } else if (t2 != null && t1 == null) {
            root = new TreeNode(t2.val);
        } else if (t1 != null && t2 != null) {
            root = new TreeNode(t1.val + t2.val);
        } else {
            return null;
        }

        TreeNode l1, l2, r1, r2;

        l1 = t1 != null ? t1.left : null;
        l2 = t2 != null ? t2.left : null;

        r1 = t1 != null ? t1.right : null;
        r2 = t2 != null ? t2.right : null;

        root.left = mergeTrees(l1, l2);
        root.right = mergeTrees(r1, r2);

        return root;
    }
}