package app;

import java.util.ArrayList;

public class Solution {
    public int minDiffInBST(TreeNode root) {

        if (root == null) {
            return 0;
        }

        ArrayList<TreeNode> stack = new ArrayList<>();

        stack.add(root);
        int num = stack.get(stack.size() - 1).val;
        int min = 0;

        if (root.left != null) {
            min = Math.abs(num - root.left.val);
        } else if (root.right != null) {
            min = Math.abs(num - root.right.val);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.remove(stack.size() - 1);
            int val = node.val;

            if (val != num) {
                int dif = Math.abs(num - val);
                if (dif < min) {
                    min = dif;
                } else if (dif > min) {
                    int temp = dif - min;
                    if (temp < min) {
                        min = temp;
                    }
                }
            }

            if (node.left != null)
                stack.add(node.left);

            if (node.right != null)
                stack.add(node.right);
        }

        return min;
    }
}