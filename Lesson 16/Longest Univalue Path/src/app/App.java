package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getSubMaxNode(root).max - 1;
    }

    public State getSubMaxNode(TreeNode node) {
        if (node == null) {
            return new State(Integer.MAX_VALUE, 0, Integer.MIN_VALUE);
        }

        State left = getSubMaxNode(node.left);
        State right = getSubMaxNode(node.right);

        return getMyState(left, right, node.val);
    }

    public State getMyState(State left, State right, int currVal) {
        int max = 1;
        int length = 1;

        int leftLen = left.length;
        int rightLen = right.length;

        if (currVal == left.nodeVal && currVal == right.nodeVal) {
            length += rightLen > leftLen ? rightLen : leftLen;
            max = Math.max(max, rightLen + leftLen + 1);
        } else {
            if (currVal == left.nodeVal) {
                length += leftLen;
                max = Math.max(max, length);
            } else if (currVal == right.nodeVal) {
                length += rightLen;
                max = Math.max(max, length);
            }
        }

        max = Math.max(max, left.max);
        max = Math.max(max, right.max);

        return new State(currVal, length, max);
    }
}

class State {
    public int nodeVal;
    public int length;
    public int max;

    public State(int nodeVal, int length, int max) {
        this.nodeVal = nodeVal;
        this.length = length;
        this.max = max;
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