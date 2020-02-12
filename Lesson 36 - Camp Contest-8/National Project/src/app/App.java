package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmount = scanner.nextInt();
        scanner.nextLine();

        String[] testCases = new String[testCaseAmount];

        for (int i = 0; i < testCaseAmount; i++) {
            testCases[i] = scanner.nextLine();
        }

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(makeHalfHighQuality(testCases[i]));
        }

        scanner.close();
    }

    private static int makeHalfHighQuality(String string) {
        String[] data = string.split(" ");
        int n = Integer.parseInt(data[0]);
        int g = Integer.parseInt(data[1]);
        int b = Integer.parseInt(data[2]);

        return 0;
    }
}