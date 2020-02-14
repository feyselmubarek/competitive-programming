package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < richer.length; i++) {
            int key = richer[i][1];

            if (adjList.containsKey(key)) {
                adjList.get(key).add(richer[i][0]);
            } else {
                List<Integer> nigh = new ArrayList<>();
                nigh.add(richer[i][0]);

                adjList.put(key, nigh);
            }
        }

        HashMap<Integer, Integer> memo = new HashMap<>();
        int[] res = new int[quiet.length];

        for (int i = 0; i < quiet.length; i++) {
            if (!memo.containsKey(i)) {
                chooseTheQuitest(memo, res, i, adjList, quiet);
            }
        }

        return res;
    }

    public int chooseTheQuitest(HashMap<Integer, Integer> memo, int[] res, int i,
            HashMap<Integer, List<Integer>> adjList, int[] quite) {
        if (!memo.containsKey(i)) {
            int min = i;

            if (adjList.containsKey(i)) {
                List<Integer> list = adjList.get(i);

                for (int n : list) {
                    int n_val = chooseTheQuitest(memo, res, n, adjList, quite);

                    if (quite[min] > quite[n_val]) {
                        min = n_val;
                    }
                }
            }

            memo.put(i, min);
            res[i] = min;
        }

        return memo.get(i);
    }
}