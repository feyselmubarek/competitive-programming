// question-link : https://codeforces.com/problemset/problem/664/A
package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[] numbersRange = scanner.nextLine().split(" ");
        System.out.println(findGCD(numbersRange));

        scanner.close();
    }

    public static String findGCD(String[] strArr) {
        return strArr[0].equals(strArr[1]) ? strArr[0] : "1";
    }
}