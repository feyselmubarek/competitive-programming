package app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int num = 0;

        for (int[] arr : dominoes) {
            int c = arr[0], d = arr[1];

            String a = c + " " + d;
            String b = d + " " + c;

            if (map.containsKey(a)) {
                int pair = map.get(a) + 1;
                num += pair;
                map.put(a, pair);
            } else if (map.containsKey(b)) {
                int pair = map.get(b) + 1;
                num += pair;
                map.put(b, pair);
            } else {
                map.put(a, 0);
            }
        }

        return num;
    }
}