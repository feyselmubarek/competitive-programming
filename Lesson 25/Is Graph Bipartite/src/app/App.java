package app;

import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } }));
    }

    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        HashSet<Integer> visted = new HashSet<>();

        for (int node = 0; node < graph.length; node++) {
            if (!visted.contains(node)) {
                if (!makeGroup(A, B, visted, node, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean makeGroup(HashSet<Integer> A, HashSet<Integer> B, HashSet<Integer> visted, int node, int[][] graph) {
        int[] neighbours = graph[node];
        HashSet<Integer> mine = A.contains(node) ? A : B;
        HashSet<Integer> opp = A.contains(node) ? B : A;

        mine.add(node);
        visted.add(node);

        for (int neig : neighbours) {
            if (mine.contains(neig)) {
                return false;
            }

            if (!visted.contains(neig)) {
                opp.add(neig);

                if (!makeGroup(A, B, visted, neig, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
}