package app;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        if ((node.val > Math.min(p.val, q.val) && node.val < Math.max(p.val, q.val)) || node.val == p.val
                || node.val == q.val) {
            return node;
        }

        if (node.val > p.val && node.val > q.val) {
            return lowestCommonAncestor(node.left, p, q);
        }

        return lowestCommonAncestor(node.right, p, q);
    }
}