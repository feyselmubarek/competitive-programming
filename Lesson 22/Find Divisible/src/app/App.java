package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testcaseAmount = scanner.nextInt();
        scanner.nextLine();

        String[] testcases = new String[testcaseAmount];

        for (int i = 0; i < testcases.length; i++) {
            testcases[i] = scanner.nextLine();
        }

        for (String string : testcases) {
            System.out.println(printDivisblePair(string));
        }

        scanner.close();
    }

    private static String printDivisblePair(String string) {
        int l = Integer.parseInt(string.split(" ")[0]);

        return l + " " + (2 * l);
    }
}