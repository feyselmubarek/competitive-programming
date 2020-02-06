package app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int maxProduct(TreeNode root) {
        int totalTreeSum = 0;
        List<Integer> list = new ArrayList<>();

        totalTreeSum = getSubTreeSum(root, list);
        int min = Integer.MAX_VALUE, num = 0, num2 = 0;

        for (int i : list) {
            int first = totalTreeSum - i;
            int second = i;

            if (Math.abs(second - first) < min) {
                min = Math.abs(second - first);
                num = first;
                num2 = second;
            }
        }

        Double d = ((double) num * (double) num2) % (1000000007);
        Integer result = d.intValue();

        return result;
    }

    public int getSubTreeSum(TreeNode node, List<Integer> list) {
        if (node == null) {
            return 0;
        }

        int left = 0, right = 0;

        if (node.left != null) {
            left = getSubTreeSum(node.left, list);
        }

        if (node.right != null) {
            right = getSubTreeSum(node.right, list);
        }

        list.add(left + right + node.val);

        return left + right + node.val;
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