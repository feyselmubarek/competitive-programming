package app;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root1 != null) {
            stack.push(root1);
        }

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            minHeap.add(n.val);

            if (n.left != null)
                stack.push(n.left);

            if (n.right != null)
                stack.push(n.right);
        }

        if (root2 != null)
            stack.push(root2);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            minHeap.add(n.val);

            if (n.left != null)
                stack.push(n.left);

            if (n.right != null)
                stack.push(n.right);
        }

        while (!minHeap.isEmpty())
            list.add(minHeap.poll());

        return list;
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