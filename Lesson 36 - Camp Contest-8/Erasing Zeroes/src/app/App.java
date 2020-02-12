package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmmount = scanner.nextInt();
        scanner.nextLine();

        String[] testCase = new String[testCaseAmmount];

        for (int i = 0; i < testCaseAmmount; i++) {
            String line = scanner.nextLine();
            testCase[i] = line;
        }

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(eraseZero(testCase[i]));
        }
        scanner.close();
    }

    public static int eraseZero(String string) {

        boolean isOneFound = false;
        int zero = 0;
        int total = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                isOneFound = true;
                total += zero;
                zero = 0;
            } else if (isOneFound) {
                zero++;
            }

        }

        return total;
    }
}