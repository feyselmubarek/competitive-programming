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
        String[] arr = string.split(" ");

        int l = Integer.parseInt(arr[0]);
        int r = Integer.parseInt(arr[1]);

        for (int i = l; i <= r; i++) {
            if ((2 * i) <= r && i != 0) {
                return i + " " + (2 * i);
            }
        }

        return "";
    }

}