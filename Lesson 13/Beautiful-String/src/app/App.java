package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmmount = scanner.nextInt();
        String[] testCase = new String[testCaseAmmount];

        for (int i = 0; i < testCaseAmmount; i++) {
            String line = scanner.next();
            testCase[i] = line;
        }

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(makeBeautiful(testCase[i]));
        }
        scanner.close();
    }

    public static String makeBeautiful(String line) {
        StringBuilder res = new StringBuilder(line);
        char p = line.charAt(0);
        char curr;

        if (line.length() == 1) {
            if (line.charAt(0) == '?') {
                res.setCharAt(0, getDifferentCharForOne(line.charAt(0)));
            } else {
                res.setCharAt(0, line.charAt(0));
            }
            return res.toString();
        }

        for (int i = 0; i < line.length(); i++) {
            curr = line.charAt(i);

            if (i == 0) {
                if (curr == '?') {
                    char c = getDifferentCharForOne(line.charAt(i + 1));
                    res.setCharAt(i, c);
                    p = c;
                } else {
                    res.setCharAt(i, curr);
                }
            } else if (i == line.length() - 1) {
                if (curr == '?') {
                    char c = getDifferentCharForOne(p);
                    res.setCharAt(i, c);
                    return res.toString();
                } else {
                    if (p == curr) {
                        return "-1";
                    }
                    res.setCharAt(i, curr);
                }
            } else {
                if (p == curr && i != 0) {
                    return "-1";
                }

                if (curr == '?') {
                    char a = line.charAt(i + 1);

                    if (i != 0 && (i + 1) < line.length()) {
                        char c = getDifferentChar(p, a);
                        res.setCharAt(i, c);
                        p = c;
                    }
                } else {
                    res.setCharAt(i, curr);
                    p = curr;
                }
            }
        }
        return res.toString();

    }

    public static char getDifferentChar(char b, char a) {
        char tobeReturn;

        if (b == 'a') {
            if (a == 'a') {
                tobeReturn = 'b';
            } else if (a == 'b') {
                tobeReturn = 'c';
            } else {
                tobeReturn = 'b';
            }

        } else if (b == 'b') {
            if (a == 'a') {
                tobeReturn = 'c';
            } else if (a == 'b') {
                tobeReturn = 'c';
            } else {
                tobeReturn = 'a';
            }
        } else {
            if (a == 'a') {
                tobeReturn = 'b';
            } else if (a == 'b') {
                tobeReturn = 'a';
            } else {
                tobeReturn = 'b';
            }
        }

        return tobeReturn;
    }

    public static char getDifferentCharForOne(char b) {
        char tobeReturn;

        if (b == 'a') {
            tobeReturn = 'b';
        } else if (b == 'b') {
            tobeReturn = 'c';
        } else {
            tobeReturn = 'a';
        }

        return tobeReturn;
    }
}