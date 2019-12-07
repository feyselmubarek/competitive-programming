// package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmmount = scanner.nextInt();
        String[] testCase = new String[testCaseAmmount];

        for (int i = 0; i < testCaseAmmount; i++) {
            scanner.nextInt();
            scanner.nextLine();

            String line = scanner.nextLine();
            testCase[i] = line;
        }

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(makeBeautiful(testCase[i]));
        }
        scanner.close();
    }

    private static String makeBeautiful(String string) {
        String[] data = string.split(" ");
        int min, max;
        int[] position = new int[data.length];

        int index = 1;
        for (String str : data) {
            position[Integer.parseInt(str) - 1] = index;
            index++;
        }

        min = position[0];
        max = position[0];
        StringBuilder result = new StringBuilder(string);

        for (int i = 0; i < position.length; i++) {
            min = min > position[i] ? position[i] : min;
            max = max < position[i] ? position[i] : max;

            if (max - min + 1 == (i + 1)) {
                result.setCharAt(i, '1');
            } else {
                result.setCharAt(i, '0');
            }
        }

        return result.substring(0, max);
    }
}