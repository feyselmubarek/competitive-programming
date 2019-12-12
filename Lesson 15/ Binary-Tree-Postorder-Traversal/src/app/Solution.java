package app;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> leftNode = null, rightNode = null;

        if (root == null) {
            return list;
        }

        if (root.left != null) {
            leftNode = postorderTraversal(root.left);
        }

        if (root.right != null) {
            rightNode = postorderTraversal(root.right);
        }

        if (leftNode != null) {
            list.addAll(leftNode);
        }

        if (rightNode != null) {
            list.addAll(rightNode);
        }

        list.add(root.val);

        return list;
    }
}