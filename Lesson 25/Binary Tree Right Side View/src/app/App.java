package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> levelMap = new HashMap<>();

        // dfs
        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(root, 1));
        levelMap.put(1, root.val);

        while (!stack.isEmpty()) {
            Pair p = stack.pop();

            if (!levelMap.containsKey(p.level)) {
                levelMap.put(p.level, p.node.val);
            }

            if (p.node.left != null) {
                stack.push(new Pair(p.node.left, p.level + 1));
            }

            if (p.node.right != null) {
                stack.push(new Pair(p.node.right, p.level + 1));
            }
        }

        return new ArrayList<Integer>(levelMap.values());
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

class Pair {
    public TreeNode node;
    public int level;

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}