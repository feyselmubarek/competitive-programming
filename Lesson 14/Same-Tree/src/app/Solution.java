package app;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean leftNodeBool = true, rightNodeBool = true;

        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        TreeNode l1, l2, r1, r2;

        l1 = p != null ? p.left : null;
        l2 = q != null ? q.left : null;

        r1 = p != null ? p.right : null;
        r2 = q != null ? q.right : null;

        leftNodeBool = isSameTree(l1, l2);
        rightNodeBool = isSameTree(r1, r2);

        return leftNodeBool && rightNodeBool;
    }
}