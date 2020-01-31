package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return findMyDeep(root, 0).possibleNode;
    }

    public State findMyDeep(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            return new State(level, node);
        }

        State leftState = null;
        State rightState = null;
        State resultState = null;

        if (node.left != null) {
            leftState = findMyDeep(node.left, level + 1);
        }

        if (node.right != null) {
            rightState = findMyDeep(node.right, level + 1);
        }

        if (leftState != null) {
            resultState = leftState;
        }

        if (rightState != null) {
            if (resultState != null) {
                if (rightState.level == resultState.level) {
                    rightState.possibleNode = node;

                } else if (rightState.level < resultState.level) {
                    return resultState;
                }
            }

            return rightState;
        }

        return resultState;
    }
}

class State {
    public int level;
    public TreeNode possibleNode;

    public State(int level, TreeNode possibleNode) {
        this.level = level;
        this.possibleNode = possibleNode;
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