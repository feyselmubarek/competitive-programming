package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int noOfCommands = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();

        System.out.println(noOfCommands + 1);
        scanner.close();
    }
}