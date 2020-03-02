package app;

import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();

        if (root == null) {
            return postOrderList;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            postOrderList.add(currentNode.val);

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }

        Collections.reverse(postOrderList);

        return postOrderList;
    }
}