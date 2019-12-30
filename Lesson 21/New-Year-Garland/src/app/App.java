package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmmount = scanner.nextInt();
        String[] testCase = new String[testCaseAmmount];
        scanner.nextLine();

        for (int i = 0; i < testCaseAmmount; i++) {
            String line = scanner.nextLine();
            testCase[i] = line;
        }

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(isGarland(testCase[i]));
        }
        scanner.close();
    }

    private static String isGarland(String S) {
        String[] rgb = S.split(" ");

        long r = Long.parseLong(rgb[0]);
        long g = Long.parseLong(rgb[1]);
        long b = Long.parseLong(rgb[2]);

        long total = r + g + b;

        if (isValid(total, r, g, b)) {
            return "YES";
        }

        return "NO";
    }

    private static boolean isValid(long total, long r, long g, long b) {
        long max = r;

        if (max <= g) {
            max = g;
        }

        if (max <= b) {
            max = b;
        }

        return total % 2 == 0 ? (max <= total / 2) : (max <= ((total / 2) + 1));
    }
}