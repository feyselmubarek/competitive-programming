package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().orderlyQueue("cba", 1));
    }

    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] charArray = S.toCharArray();
            Arrays.sort(charArray);

            StringBuilder builder = new StringBuilder();
            builder.append(charArray);

            return builder.toString();
        }

        String min = S;
        String hold = S;

        for (int i = 0; i < S.length(); i++) {
            String curr = hold.substring(1, hold.length()) + hold.charAt(0);

            if (min.compareTo(curr) > 0) {
                min = curr;
            }

            hold = curr;
        }

        return min;
    }
}