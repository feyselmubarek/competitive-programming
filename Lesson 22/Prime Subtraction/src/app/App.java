// question link : https://codeforces.com/problemset/problem/1238/A
package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCaseAmount = scanner.nextInt();
        scanner.nextLine();

        String[] testCases = new String[testCaseAmount];

        for (int i = 0; i < testCases.length; i++) {
            testCases[i] = scanner.nextLine();
        }

        for (String string : testCases) {
            System.out.println(checkPrimeSubtraction(string));
        }

        scanner.close();
    }

    public static String checkPrimeSubtraction(String str) {
        String[] arr = str.split(" ");

        long num1 = Long.parseLong(arr[0]);
        long num2 = Long.parseLong(arr[1]);

        return (num1 - num2) > 1 ? "YES" : "NO";
    }
}