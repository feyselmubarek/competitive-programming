package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        new App().recoverFromPreorder("1-2--3---4-5--6---7");
    }

    public TreeNode recoverFromPreorder(String S) {
        Pair curr = new Pair();
        int nextIndex = makeNextPair(S, 0, curr);

        Stack<Pair> stack = new Stack<>();
        stack.push(curr);

        TreeNode root = curr.node;

        while (nextIndex < S.length()) {
            Pair nextPair = new Pair();
            nextIndex = makeNextPair(S, nextIndex, nextPair);

            Pair last = stack.peek();

            if (last.level < nextPair.level) {
                last.node.left = nextPair.node;
                stack.push(nextPair);
            } else {
                while (stack.peek().level >= nextPair.level) {
                    stack.pop();
                }

                stack.peek().node.right = nextPair.node;
                stack.push(nextPair);
            }

        }

        return root;
    }

    public int makeNextPair(String trav, int startIndex, Pair newPair) {
        int level = 0;
        int index = startIndex;

        while (index < trav.length()) {
            if (trav.charAt(index) != '-') {
                break;
            }
            level++;
            index++;
        }

        StringBuilder builder = new StringBuilder();

        while (index < trav.length()) {
            if (trav.charAt(index) == '-') {
                break;
            }

            builder.append(trav.charAt(index));
            index++;
        }

        int val = Integer.parseInt(builder.toString());
        TreeNode node = new TreeNode(val);

        newPair.node = node;
        newPair.level = level;

        return index;
    }
}

class Pair {
    public TreeNode node;
    public int level;
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}