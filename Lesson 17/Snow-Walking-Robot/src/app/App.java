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
            String val = arrangeInstruction(testCase[i]);
            System.out.println(val.length());
            System.out.println(val);
        }
        scanner.close();
    }

    private static String arrangeInstruction(String string) {
        int left = 0, right = 0, up = 0, down = 0;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (c == 'L') {
                left++;
            } else if (c == 'R') {
                right++;
            } else if (c == 'U') {
                up++;
            } else if (c == 'D') {
                down++;
            }
        }

        if (left < right) {
            right = left;
        } else if (right < left) {
            left = right;
        }

        if (up < down) {
            down = up;
        } else if (down < up) {
            up = down;
        }

        if (up == 0 && right != 0) {
            right = 1;
            left = 1;
        }

        if (left == 0 && up != 0) {
            up = 1;
            down = 1;
        }

        StringBuilder builder = new StringBuilder(string);
        int counter = 0;

        for (int i = 0; i < left; i++) {
            builder.setCharAt(counter, 'L');
            counter++;
        }

        for (int i = 0; i < up; i++) {
            builder.setCharAt(counter, 'U');
            counter++;
        }

        for (int i = 0; i < right; i++) {
            builder.setCharAt(counter, 'R');
            counter++;
        }

        for (int i = 0; i < down; i++) {
            builder.setCharAt(counter, 'D');
            counter++;
        }

        return builder.substring(0, counter);
    }
}