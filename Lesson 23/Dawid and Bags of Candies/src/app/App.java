package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int bag1 = scanner.nextInt();
        int bag2 = scanner.nextInt();
        int bag3 = scanner.nextInt();
        int bag4 = scanner.nextInt();

        int min = getMin(bag1, bag2, bag3, bag4);
        int max = getMax(bag1, bag2, bag3, bag4);
        int summation = bag1 + bag2 + bag3 + bag4;

        System.out.println(getResult(max, min, summation));
        scanner.close();
    }

    public static String getResult(int max, int min, int summation) {
        if ((summation / 2) > max) {
            if ((max + min) == summation - (max + min)) {
                return "YES";
            }
        } else if ((summation / 2) == max) {
            if ((max == (summation - max))) {
                return "YES";
            }
        }
        return "NO";
    }

    public static int getMax(int bag1, int bag2, int bag3, int bag4) {
        int min = bag1;

        min = bag2 > min ? bag2 : min;
        min = bag3 > min ? bag3 : min;
        min = bag4 > min ? bag4 : min;

        return min;
    }

    public static int getMin(int bag1, int bag2, int bag3, int bag4) {
        int max = bag1;

        max = bag2 < max ? bag2 : max;
        max = bag3 < max ? bag3 : max;
        max = bag4 < max ? bag4 : max;

        return max;
    }
}