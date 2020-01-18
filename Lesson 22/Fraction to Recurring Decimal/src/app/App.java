package app;

import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello Java");

        // System.out.println((double) 1 / 7);

        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(4);
        set.add(7);
        set.add(8);


        for (set) {
            
        }
    }

    public String fractionToDecimal(int numerator, int denominator) {
        String posibleRepeatitiveChars = "", decimal = "" + ((double) numerator / denominator);
        String answer = "";
        boolean isPointFound = false;

        for (int i = 0; i < decimal.length(); i++) {
            char c = decimal.charAt(i);

            if (c == '.') {
                answer += c;
                isPointFound = true;
            } else {
                if (isPointFound) {

                } else {
                    answer += c;
                }
            }

        }

        return answer;
    }
}