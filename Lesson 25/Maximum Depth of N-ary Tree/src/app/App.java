package app;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int maxDepth(Node root) {
        if (root != null) {

            if (root.children == null) {
                return 1;
            }

            int childMaxDepth = 0;

            for (Node child : root.children) {
                int childDepth = maxDepth(child);

                if (childDepth > childMaxDepth) {
                    childMaxDepth = childDepth;
                }
            }

            return childMaxDepth + 1;
        }

        return 0;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};