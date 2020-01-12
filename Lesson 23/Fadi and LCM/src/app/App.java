package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        long gcd = scanner.nextLong();
        System.out.println(getMinimumOfMax(gcd));

        scanner.close();
    }

    private static String getMinimumOfMax(long gcd) {

        int sqrt = (int) Math.sqrt(gcd);

        for (int i = sqrt; i > 0; i--) {
            if (gcd % i == 0) {
                if (findGCD(gcd / i, i) == 1) {
                    return i + " " + (gcd / i);
                }
            }
        }

        return "";
    }

    private static long findGCD(long a, long b) {
        if (b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }
}