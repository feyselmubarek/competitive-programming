package app;

import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        for (int i = 0; i < mat.length; i++) {
            int sol = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }

                sol++;
            }

            minHeap.add(new Pair(sol, i));
        }

        int[] res = new int[k];

        for (int i = 0; i < res.length; i++) {
            res[i] = minHeap.poll().index;
        }

        return res;
    }
}

class Pair implements Comparable<Pair> {
    public int solider;
    public int index;

    public Pair(int solider, int index) {
        this.solider = solider;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        if (o.solider < this.solider) {
            return 1;
        } else if (o.solider == this.solider) {
            if (this.index > o.index) {
                return 1;
            }
        }

        return -1;
    }
}