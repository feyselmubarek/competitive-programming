// question link : https://codeforces.com/problemset/problem/854/A
package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int holder = number;

        String result = "";

        if (number % 2 != 0) {
            int half = number / 2;
            result = half + " " + (half + 1);
        } else {
            number = number / 2;

            if (number % 2 == 0) {
                result = (number - 1) + " " + (number + 1);
            } else {
                int newNum = number - 2;
                result = newNum + " " + (holder - newNum);
            }
        }

        System.out.println(result);
        scanner.close();
    }
}