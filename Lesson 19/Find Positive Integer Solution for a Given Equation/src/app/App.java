package app;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> listOfAnswers = new Solution().findSolution(new CustomFunction(), 5);

        System.out.println();
        for (List<Integer> list : listOfAnswers) {
            for (Integer in : list) {
                System.out.print(in + ", ");
            }
            System.out.println();
        }
    }
}