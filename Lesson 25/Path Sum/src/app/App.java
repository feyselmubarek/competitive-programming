// question link : https://leetcode.com/problems/path-sum/
package app;

import java.util.HashSet;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello Java");
        // test the code online using the question link
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();

        if (root != null) {
            stack.push(root);
            int tempSum = root.val;

            while (!stack.isEmpty()) {
                TreeNode currentNode = stack.peek();

                if (currentNode.left != null && !set.contains(currentNode.left)) {
                    set.add(currentNode.left);
                    stack.push(currentNode.left);
                    tempSum += currentNode.left.val;
                    continue;
                }

                if (currentNode.right != null && !set.contains(currentNode.right)) {
                    set.add(currentNode.right);
                    stack.push(currentNode.right);
                    tempSum += currentNode.right.val;
                    continue;
                }

                if (currentNode.left == null && currentNode.right == null) {
                    if (tempSum == sum) {
                        return true;
                    }
                }

                tempSum -= stack.pop().val;
            }
        }

        return false;
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