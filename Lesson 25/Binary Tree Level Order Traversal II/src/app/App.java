package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode node = root;
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(node, 0));
        result.add(new ArrayList<>(Arrays.asList(node.val)));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            if (curr.node.left != null) {
                Pair left = new Pair(curr.node.left, curr.level + 1);
                addList(left, result);
                queue.add(left);
            }

            if (curr.node.right != null) {
                Pair right = new Pair(curr.node.right, curr.level + 1);
                addList(right, result);
                queue.add(right);
            }
        }

        Collections.reverse(result);

        return result;
    }

    public void addList(Pair pair, List<List<Integer>> result) {
        int index = pair.level;
        List<Integer> innerList = null;

        if (result.size() == index) {
            innerList = new ArrayList<>();
            result.add(innerList);
        } else {
            innerList = result.get(index);
        }

        innerList.add(pair.node.val);
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}