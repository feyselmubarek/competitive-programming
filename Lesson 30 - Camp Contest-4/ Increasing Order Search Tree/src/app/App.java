package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("test");
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode result = null, ans = null;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();

                if (result == null) {
                    result = new TreeNode(node.val);
                    ans = result;
                } else {
                    result.right = new TreeNode(node.val);
                    result = result.right;
                }

                node = node.right;
            }
        }

        return ans;
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