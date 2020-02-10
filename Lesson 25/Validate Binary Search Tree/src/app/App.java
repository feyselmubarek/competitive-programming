package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, prevNode = null;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prevNode == null) {
                    prevNode = node;
                } else {
                    if (node.val <= prevNode.val) {
                        return false;
                    }

                    prevNode = node;
                }

                node = node.right;
            }
        }

        return true;
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