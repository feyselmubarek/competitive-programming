package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().numRollsToTarget(1, 6, 3));
        System.out.println(new App().numRollsToTarget(2, 5, 10));
        System.out.println(new App().numRollsToTarget(2, 6, 7));
        System.out.println(new App().numRollsToTarget(1, 2, 3));
        System.out.println(new App().numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int d, int f, int target) {
        ArrayList<Integer> prev = new ArrayList<>();

        for (int i = 0; i < f; i++) {
            prev.add(1);
        }

        for (int j = 1; j < d; j++) {
            ArrayList<Integer> curr = new ArrayList<>();
            Double sum = 0D;

            for (int i = -1 * f; i < prev.size() - 1; i++) {
                if (i + f < f) {
                    sum += prev.get(i + f);
                } else if (i + f >= prev.size()) {
                    sum -= prev.get(i);
                } else {
                    sum += prev.get(i + f);
                    sum -= prev.get(i);
                }
                curr.add((int) (sum % 1000000007));
            }
            prev = curr;
        }

        if (target - d >= prev.size()) {
            return 0;
        }

        return prev.get(target - d);
    }
}