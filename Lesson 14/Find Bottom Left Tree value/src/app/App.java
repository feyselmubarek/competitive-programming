package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int findBottomLeftValue(TreeNode root) {
        return find(root, 0).node.val;
    }

    public State find(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            return new State(node, level);
        }

        State left = null, right = null, res = null;

        if (node.left != null) {
            left = find(node.left, level + 1);
        }

        if (node.right != null) {
            right = find(node.right, level + 1);
        }

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}