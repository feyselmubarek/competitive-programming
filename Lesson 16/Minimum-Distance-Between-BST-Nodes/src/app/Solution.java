package app;

import java.util.*;

public class Solution {
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        int min = Integer.MAX_VALUE;
        TreeNode node = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();

                if (prev != null) {
                    min = Math.min(min, node.val - prev.val);
                }

                prev = node;
                node = node.right;
            }
        }

        return min;
    }
}