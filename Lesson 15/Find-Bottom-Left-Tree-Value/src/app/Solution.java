package app;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return find(root, 0).node.val;
    }

    public State find(TreeNode node, int level) {
        if (node == null) {
            return null;
        }

        State res = new State(node, level);
        State left = find(node.left, level + 1);
        ;
        State right = find(node.right, level + 1);

        if (left != null) {
            res = left;
        }

        if (right != null) {
            if (res == null || right.level > res.level) {
                res = right;
            }
        }

        return res;
    }
}

class State {
    public TreeNode node;
    public int level;

    public State(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}