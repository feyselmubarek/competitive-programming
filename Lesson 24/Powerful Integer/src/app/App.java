package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> test = new App().powerfulIntegers(2, 3, 10);

        System.out.println();
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
        System.out.println();
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int sum = 0;

        int xBound = x == 1 ? 1 : (int) (Math.log(bound - 1) / Math.log(x));
        int yBound = y == 1 ? 1 : (int) (Math.log(bound - 1) / Math.log(y));

        for (int i = 0; i <= xBound; i++) {
            for (int j = 0; j <= yBound; j++) {
                sum = (int) (Math.pow(x, i) + Math.pow(y, j));

                if (sum <= bound && !set.contains(sum)) {
                    set.add(sum);
                }
            }
        }

        result.addAll(set);

        return result;
    }
}