package app;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int i = 1, j = 10;
        int y = 0, res = 0;
        List<List<Integer>> listOfAnswers = new ArrayList<List<Integer>>();

        for (int x = 1; x <= 1000; x++) {

            while (i <= j) {

                y = i == j ? i : (i + j - 1) / 2;
                res = customfunction.f(x, y);

                if (res > z) {
                    j = y - 1;
                } else if (res < z) {
                    i = y + 1;
                } else {
                    ArrayList<Integer> inner = new ArrayList<>();
                    inner.add(x);
                    inner.add(y);

                    listOfAnswers.add(inner);
                    break;
                }
            }
            i = 1;
            j = 1000;
        }

        return listOfAnswers;
    }
}