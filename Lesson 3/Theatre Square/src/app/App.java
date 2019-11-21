package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();

        long xAnswer = (m % a) == 0 ? (m / a) : (m / a) + 1;
        long yAnswer = (n % a) == 0 ? (n / a) : (n / a) + 1;

        System.out.println(xAnswer * yAnswer);
        scanner.close();
    }
}