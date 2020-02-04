package app;

import java.util.HashSet;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(new Edge(1, 2).hashCode() == new Edge(1, 2).hashCode());
        System.out.println(new App().findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
    }

    public int findCircleNum(int[][] M) {
        int count = 0;
        HashSet<Integer> visted = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 0; i < M.length; i++) {
            if (!visted.contains(i)) {
                visted.add(i);
                stack.add(i);

                count++;
            }

            while (!stack.isEmpty()) {
                int node = stack.pop();

                for (int j = 0; j < M[node].length; j++) {
                    if (M[node][j] == 1 && !visted.contains(j)) {
                        if (node != j) {
                            stack.push(j);
                        }
                        visted.add(j);
                    }
                }
            }
        }

        return count;
    }
}