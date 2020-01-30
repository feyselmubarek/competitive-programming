package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().minIncrementForUnique(new int[] { 1, 1 }));
    }

    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        int holder = A[0];
        int moves = 0;

        for (int i = 1; i < A.length; i++) {
            if (holder >= A[i]) {
                holder++;
                moves += holder - A[i];
            } else {
                holder = A[i];
            }
        }

        return moves;
    }
}